/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CManager.java 
 * @@brief    
 * @@version  1.0
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.controller;

//--------- Standar Libraries import
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

import coursemanager.model.CAcademicProgram;
import coursemanager.model.CCourse;
import coursemanager.model.CCurriculum;
import coursemanager.model.CCurriculumCourse;
import coursemanager.model.CDepartment;
import coursemanager.model.CFaculty;
import coursemanager.model.CLogin;
import coursemanager.model.CStudent;
import coursemanager.model.CStudentAdmin;
import coursemanager.model.CodRes;

// -------- Class declaration and documentation
/**<br> The manager that links the inner classes to the external world. <\br>
 * @@invariant: The variable sTempAcademicPro is NULL if that it initiates
 * 			   session is a student or an advisor. If sTempAcademicPro is 
 * 			   a coordinator it keeps the department from which the user is coordinating    
 */
public class CManager {
       /**
	    * A list of the university faculties
	    */
	   private ArrayList<CFaculty> faculties;
	   
	   /**
	    * An administrator for the students
	    */
	   private CStudentAdmin studentAdmin;	   

	   /**
	    * Name of an academic program
	    */
	   private String sTempAcademicProg;
	   
	   /**
	    * Object that contains information about users and passwords
	    */
	   private CLogin theLoger;
	   
	   /**
	    * Code of the student. Different to null only if a student is the user.
	    */	   
	   private int nCodeStudent;


	   /**
	   * Class constructor 
	   * @@pre: true 
	   * @@post: A Manager's instance is created 
	   */   
	   public CManager() 
	   {
	      faculties = new ArrayList<CFaculty>();	
	      studentAdmin = new CStudentAdmin();
	      theLoger = new CLogin(this);
	      nCodeStudent = 0;
	   }
	   
	   /**
	   * @@brief: Given the name of an academic program, this function returns the 
	   * academic program as an object   
	   * @@pre: The string is valid    
	   * @@post: An object of type CAcademicProgram is returned if the name given 
	   * belong to one, otherwise returns NULL   
	   * @@param: psAcademicProgram
	   * @@return: CAcademicProgram 
	   * @@aditional_description: none  
	   */
	   private CAcademicProgram getAcademicProgram(String psAcadProgCode) 
	   {
		   if(psAcadProgCode.equals(""))
		   {
			   int code = getUserStudentCode();
			   psAcadProgCode = studentAdmin.getMajor(code);
		   }
		   CDepartment dept = getDepartment(psAcadProgCode);
		   return dept.getAcademicProgram(psAcadProgCode);
	   }
	    		   
	  /**
	  * @@brief: Given the name of an academic program this function returns the department.   
	  * @@pre: The string is valid    
	  * @@post: An string with the department name is returned, this string is not 
	  * 	   empty if the given string belongs to an academic program, is empty if the given 
	  * 	   string does not belong to an academic program   
	  * @@param: psAcademicProgram Ex:ISIS
	  * @@return: CDepartment Department that contains an academic program with name = psAcadProgCode
	  * @@aditional_description: none  
	  */
	   private CDepartment getDepartment(String psAcadProgCode) 
	   {
		   CDepartment dept = null;
		   for(CFaculty fac : faculties)
		   {
			   dept = fac.getDepartmentFromAcadProg(psAcadProgCode);
			   if(dept != null)
				   return dept;		   
		   }
		   return dept;
	   }
	   
	   private CDepartment getDepartment(Integer departmentId) 
	   {
		   CDepartment dept =  null;
		   for(CFaculty fac : faculties)
		   {
			   dept = fac.getDepartment(departmentId);
			   if(dept != null)
				   return dept;		   
		   }
		   return dept;
	   }
	   
	   /**
	    * @@brief: Given a faculty's name returns the faculty.
	    * @@pre: true.     
	    * @@post: Returns the faculty.
	    * @@param: psFaculty Is the faculty's name   
	    * @@return: The faculty, null if it doesn't exists.
	    */
	   public CFaculty getFaculty(String psFaculty)
	   {
		   CFaculty faculty = null;
		   boolean found = false;
		   Iterator it = faculties.iterator();
		   while (it.hasNext() && !found)
		   {
			   faculty = (CFaculty)it.next();
			   if ( faculty.getName().equals(psFaculty))
			   {
				   found = true;
			   }			   
		   }
		   if (found)
		   {
			   return faculty;
		   }
		   else
		   {
			   return null;
		   }
		}
		   
	  /**
	  * @@brief: This method adds a department into a faculty given its name, 
	  * 		coordinators name and faculty name.  
	  * @@pre: the strigns are valid    
	  * @@post: A department is added if none of the values enter into the metodh is 
	  * 	   repeated in other department, coordinor or faculty respectively . If this does 
	  * 	   not happend no accion is performed.
	  * @@param: psName
	  * @@param: psFaculty
	  * @@return: CodRes ERROR if a parameter is not valid.
	  * @@return: CodRes OBJECT_NOT_FOUND if the faculty doesn't exists.
	  * @@return: CodRes SUCCESS if everything is fine.
	  * @@aditional_description: Neither of the arguments should be repeated into the 
	  * unversity, except maybe, coordinators. 
	  */
	   public CodRes addDepartment(Integer departmentId, String psFaculty) 
	   {
		   CFaculty faculty;
		   
		   if ( departmentId == null || psFaculty == null)
		      return CodRes.ERROR; //ERROR
		   
		   faculty = getFaculty(psFaculty);
		   if (faculty == null)
		      return CodRes.OBJECT_NOT_FOUND; //NOT_EXISTS
		   else
		   {
			   faculty.addDepartment(departmentId);	
			   return CodRes.SUCCESS; //OK
		   }
	   }
	   
	  /**
	  * @@brief: Adds an academic program to an associaed department. Academic 
	  * 		programs cannot be repeated.   
	  * @@pre: Strings are valid     
	  * @@post: An academic program is added if none of the values enter into the 
	  * 	   metodh is repeated in other department or  faculty, respectively . If this does 
	  *		   not happend, no accion is performed. 
	  * @@param: psFaculty
	  * @@param: psDepartment
	  * @@param: psProgramName
	  * @@return: CodRes INVALID_ARGUMENTS if a parameter is not valid.
	  * @@return: CodRes SUCCESS if everything is fine.
	  * @@return: CodRes ALREADY_EXISTS if the program already exists.
	  * @@aditional_description: none  
	  */
	  public CodRes addAcademicProgram(String psFaculty, Integer psDepartment, String psProgramName, String psProgramCode) 
	  {
		  CFaculty faculty;
		  CDepartment dept;
		  CAcademicProgram acaProg;
		  
		  if (psFaculty == "" || psDepartment == null || psProgramName == "" || psProgramCode == "" )
		  {
			  return CodRes.INVALID_ARGUMENTS; //INVALID_DATA
		  }
		  
		  faculty = getFaculty(psFaculty);
		  
		  if (faculty == null)   //Faculty doesn't exists
		  {
			  faculty = new CFaculty(psFaculty);    //creates a faculty
			  faculty.addDepartment(psDepartment);  //add it a department
			  
			  dept = faculty.getDepartment(psDepartment);
			  dept.addAcademicProgram(psProgramName, psProgramCode); //add a program to dept.			  
			  faculties.add(faculty);  //add faculty
			  return CodRes.SUCCESS;  //OK
			  
		  }
		  else    //Faculty exists
		  {
			  dept = getDepartment(psProgramCode);
			  if (dept == null)    //Dept doesn't exists.
			  {
				  faculty.addDepartment(psDepartment);   //adds a dept.
				  dept = faculty.getDepartment(psDepartment);
				  return dept.addAcademicProgram(psProgramName, psProgramCode);   //adds a program to dept 
				  
			  }
			  else   //Faculty and Department exists.
			  {
				  return dept.addAcademicProgram(psProgramName, psProgramCode); 
			  }
		  }	    
	  }
	   
	  /**
	  * @@brief: This method verifies the sintaxis of its argumnets and checks out 
	  * 		that they are consistent. Then adds the student 
	  * @@pre: The strings are valid     
	  * @@post: a new student is created if and only if the argumets in the method 
	  * 	   are valid. Returns a resut code O.K or ERROR_ADDING_STUDENT
	  * @@param: psName Student's name
	  * @@param: psLastName Student's last name
	  * @@param: psAddr Student's address
	  * @@param: psTel Student's phone number
	  * @@param: psResponsible Student's responsible
	  * @@param: psResTel Responsible's phone number
	  * @@param: psMajor Student's major (ISIS)
	  * @@return: CodRes ERROR if a parameter is not valid.
	  * @@return: INEXISTENT if the academic program is not found.
	  * @@return: ALREADY_EXISTS if the student already exists.
	  * @@return: SUCCESS if everything is fine.
	  */
	   public CodRes addStudent(String psName, String psLastName, String psEmail, int pnCode, String psAddr, String psDocumentType, String psDoc, String psTel, String psResponsible, String psResTel, String psMajor) 
	   {
		    CAcademicProgram acaProg;
		    CStudent newStudent;
		    CCurriculum curr;
		    
		    if ( psName == "" || psLastName == "" || psAddr == "" || psTel == "")// || psUserName == "") 
		    {
		    	return CodRes.ERROR; 
		    }
		    if ( psResponsible == "" || psResTel == "" || psMajor == "")
		    {
		    	return CodRes.ERROR;  
		    }
		    
		    acaProg = getAcademicProgram(psMajor);
		    if (acaProg == null)
		    {
		    	return CodRes.INEXISTENT; 
		    }
		   
		    curr = acaProg.getCurriculumObject();
		    newStudent = studentAdmin.addStudent(psName, psLastName, pnCode, psEmail, psDocumentType, psDoc, psAddr, psTel, psResponsible, psResTel, psMajor, curr);
		    														
		    if ( newStudent == null)
		    {
		    	return CodRes.ALREADY_EXISTS;  
		    }
		    else
		    {
		    	acaProg.addStudent(newStudent);
		    	return CodRes.SUCCESS; 
		    }		    
	    
	   }
	   
	  /**
	  * @@brief: This function validates the academic program of coordnator, and 
	  * 		inserts a rule  in agreement with the first two arguments, the method calls an 
	  * 		addition method for the rule of type given in the argument.
	  * @@pre: The Strings are valid     
	  * @@post: If the arguments are valid the rule is added nothing happends otherwise
	  * @@param: psCourse1
	  * @@param: psCourse2
	  * @@param: psType
	  * @@return: CodRes ERROR if the parameters are not valid.
	  * @@return: CodRes NOT_IN_CURRICULUM if a given course is not in the curriculum.
	  * @@return: CodRes ALREADY_EXISTS if the rule already exists.
	  * @@return: CodRes SUCCESS If everything is fine.
	  * @@aditional_description: the validation of arguments is made by the CAcademicProgram
	  */
	   public CodRes addRule(String psCourse1, String psCourse2, String psType, String psArchive) 
	   {
		
		   CAcademicProgram acaProg;
		   if (psCourse1.equals(psCourse2))
		   {
			   return CodRes.INVALID_ARGUMENTS;
		   }
		   
		   if ( psArchive == "")   //Not by archive
		   {
			   acaProg = getAcademicProgram(sTempAcademicProg);
		   }
		   else  //By archive
		   {
			   acaProg = getAcademicProgram(psArchive);
		   }			   

		   if ( psType == "PRE")
		   {
			   return acaProg.addPreRule(psCourse1, psCourse2); 
		   }
		   else if ( psType == "COR")
		   {
			   return acaProg.addCorrRule(psCourse1, psCourse2);
		   }
		   else
		   {
			   return CodRes.ERROR;  
		   }	   
    
	   }
	   
	  /**
	  * @@brief: This method works out similar to the above, but the rule in 
	  * 		additition here is a rule concerning an area  
	  * @@pre: The credit number must be greater than 0    
	  * @@post: If the arguments are valid the rule is added, if they are not no 
	  * 	   action is taken.
	  * @@param: psArea
	  * @@param: psCourse
	  * @@param: pnNum_Courses Number of courses to see.
	  * @@return: CodRes ERROR If a parameter is not valid.
	  * @@return: CodRes NEW_RULE If a new area has been created.
	  * @@return: CodRes SUCCESS If a course was added into an existent area. 
	  * @@aditional_description: The validation of the arguments is made by CAcademicProgram
	  */
	   public CodRes addAreaCourseRule(String psArea, String psCourse, int pnNum_courses, String pnArchive) 
	   {
		   CAcademicProgram acaProg;
		   if (psArea == "" || psCourse == "")
		   {
			   return CodRes.ERROR; 
		   }
		   
		   if (pnArchive == "")  //Not by archive.
		   {
			   acaProg = getAcademicProgram(sTempAcademicProg);		   
		   }
		   else  //By archive.
		   {
			   acaProg = getAcademicProgram(pnArchive);	
		   }
		   return acaProg.addAreaRule(psArea, psCourse, pnNum_courses);		
    
	   }

	  /**
	  * @@brief: Given an academic program and a code for  a course, we add this 
	  * 		course to the curriulum of the program.   
	  * @@pre: The strigns are valid    
	  * @@post: If the academic program and the course exist, th course is added to 
	  * 	   the curriculum; if not, no action is taken
	  * @@param: psAcademicProgram
	  * @@param: psCode
	  * @@return: CodRes INEXISTENT if the course wasn't found.
	  * @@return: CodRes ALREADY_EXISTS If the course is already in the curriculum.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes addCourseToCurriculum(String psFromAcadProg, String psCode, String pnArchive) 
	   {
		   CAcademicProgram acaProg;
		   if (pnArchive == "")
		   {
			   acaProg = getAcademicProgram(sTempAcademicProg);			   
		   }
		   else
		   {
			   acaProg = getAcademicProgram(pnArchive);			   
		   }
		   
		   CDepartment dept = getDepartment(psFromAcadProg);		   
		   CCourse course = dept.searchCourse(psCode);
		   
		   if ( course == null )
		   { 
			   return CodRes.INEXISTENT;   
		   }
		   else
		   {
			   return acaProg.addCourseCurriculum(course);			   
		   }	    
	   }
	   
	   /**
	  * @@brief: Given a specificaion for a course (name, code, credits, level, 
	  * 		academic program)    
	  * @@pre: The arguments have correct syntax    
	  * @@post: If the arguments are valid, acourse is created for the academic 
	  * 	   program, if not, no accion is taken. 
	  * @@param: psName
	  * @@param: psCode
	  * @@param: pfCred_Number
	  * @@param: pnLevel
	  * @@param: psAcademicProgram
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes ERROR If the department wasn't found.
	  * @@return: CodRes ALREADY_EXISTS If the course already exists.
	  * @@return: CodRes SUCCESS If everything is fine.
	  * @@aditional_description: none  
	  */
	   public CodRes createCourse(String psName, String psCode, float pfCreditNumber, int pnLevel, String psType, String psArchive) 
	   {		   
		   
		   if (psName == "" || psCode == "")
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   if (pfCreditNumber < 0 || (pfCreditNumber*10)%5 != 0)
		   {
			   return CodRes.INVALID_ARGUMENTS;
		   }
		   if (pnLevel < 1 || pnLevel > 4)
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   
		   if (psArchive == "")  //not by archive.
		   {
			   CDepartment dept = getDepartment(sTempAcademicProg);
			   return dept.addCourse(psName, psCode, pfCreditNumber, pnLevel, psType);		    		   
		   }
		   else   //by archive
		   {
			   
			   CDepartment dept = getDepartment(psArchive);
			   if (dept == null)
			   {
				   return CodRes.ERROR;
			   }
			   return dept.addCourse(psName, psCode, pfCreditNumber, pnLevel, psType);	
			   
		   }		   
	   }

	   
	  /**
	  * @@brief: Checks out if a student exist with the given code number. Method 
	  * 		verifies syntax of argument and sends the validation to the student 
	  * 		administrator.  
	  * @@pre: Code > 0.    
	  * @@post: Return true if a student with this code is found. Returns false otherwise.
	  * @@param: codigoEst. 
	  * @@return: boolean true if a student with this code is found. Returns false otherwise. 
	  */
	   public boolean verifyCode(int codigoEst) 
	   {
		   return studentAdmin.verifyIFAStudentExists(codigoEst);	    
	   }
	   
	  /**
	  * @@brief: This method changes student personal information ( telephone, 
	  * 		e-mail, resposible, respnsible's telephone), any other information can not be 
	  * 		change. The e-mail address is for an e-mail different of the one given by the 
	  * 		university 
	  * @@pre: The string values are valid     
	  * @@post: The information listed in the argumnets is now the student personal 
	  * information
	  * @@param: psNewTel
	  * @@param: psNewResponsibe
	  * @@param: psNewResTel
	  * @@param: psNewMail
	  * @@return: CodRes INEXISTENT If the student is not found.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes changeStudentPersonalInfo(int pnCode, String psTelNum, String psAddress, String psEmail, String psResponsibleName, String psResponsibleTel) 
	   {
		   if ( !isStudent())   //USER IS NOT STUDENT
		   {
			   return studentAdmin.modifyStudentPersonalInfo(pnCode, psTelNum, psAddress, psEmail, psResponsibleName, psResponsibleTel);			   
		   }
		   else
		   {
			   return studentAdmin.modifyStudentPersonalInfo(nCodeStudent, psTelNum, psAddress, psEmail, psResponsibleName, psResponsibleTel);
		   }	    
	   }
	   
	  /**
	  * @@brief: Changes the student academic information such as: semester, credit 
	  * 		number, courses or comment  
	  * @@pre: The string values are valid. Credit number and semester > 0. 
	  * @@post: The information is changed for the student
	  * @@param: psCourses
	  * @@param: pnSemester
	  * @@param: pfCreditNum
	  * @@param: psComments
	  * @@return: CodRes INEXISTENT If the student is not found.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes changeStudentAcademicInfo(int pnCode, String psCourses, int pnSemester, float pfCreditNum, String psComments) 
	   {
		   if ( !isStudent())   //USER IS NOT STUDENT
		   {
			   return studentAdmin.modifyStudentAcademicInfo(nCodeStudent, psCourses, pnSemester, pfCreditNum, psComments);			   
		   }
		   else
		   {
			   return studentAdmin.modifyStudentAcademicInfo(nCodeStudent, psCourses, pnSemester, pfCreditNum, psComments);
		   }	    
	   }
	   
	  /**
	  * @@brief: Changes a course information such as: name, credits, code and level 
	  * for an academic program given.   
	  * @@pre: credits and level are greater than 0. Strings are valid    
	  * @@post: after validation of academic program the operation is send to the 
	  * academic program responsible of changing the course, the responds is given 
	  * according with the responds of method in CAcademicProgram
	  * @@param: psName
	  * @@param: pfNumCredits
	  * @@param: psCode
	  * @@param: pnLevel
	  * @@param: psAcademicProgram
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes INEXISTENT If the course doesn't exists.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes setInfoCourse(String psName, float pfNumCredits, String psCode, int pnLevel) 
	   {
		   if (psName == "" || psCode == "")
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   if (pfNumCredits < 0 || (pfNumCredits*10)%5 != 0)
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   if (pnLevel < 1 || pnLevel > 4)
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   CDepartment dept = getDepartment(sTempAcademicProg);
		   return dept.setInfoCourse(psName, pfNumCredits, psCode, pnLevel);
	    
	   }
	   
	  /**
	  * @@brief: Method delegates delete of rule containing cours1 and cours2 of the 
	  * given type.  
	  * @@pre: Type most be ether  correq or prerq. course name most be valid strings 
	  * @@post: function calls deleteTypeRule and ruel with such type does no longer 
	  * exist in the application
	  * @@param: psCourse1
	  * @@param: psCourse2
	  * @@param: psType
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes INEXISTENT If the course doesn't exists.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes deleteRule(String psCourse1, String psCourse2, String psType) 
	   {
		   if (psCourse1 == "" || psCourse2 == "" || psType == "")
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   
		   CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		   
		   if (psType == "PRE")
		   {
			   return acaProg.deletePreRule(psCourse1, psCourse2); 
		   }
		   else if (psType == "COR")
		   {
			   return acaProg.deleteCorRule(psCourse1, psCourse2); 
		   }
		   else
		   {
			   return CodRes.ERROR;
		   }
	    
	   }
	   
	  /**
	  * @@brief: Method delegates delete of rule containing course of the given area. 
	  * @@pre: Course name most be valid strings  
	  * @@post: function calls deleteAreaRule of CAcademicProgram and area ruel does 
	  * no longer exist in the application
	  * @@param: psArea
	  * @@param: psCourse
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes INEXISTENT If the course is not in the area.
	  * @@return: CodRes SUCCESS If everything is fine.
	  */
	   public CodRes deleteAreaCourseRule(String psArea, String psCourse) 
	   {
		   if (psArea == "" || psCourse == "")
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   
		   CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);		   
		   return acaProg.deleteRuleArea(psArea, psCourse);
	    
	   }
	   
	  /**
	  * @@brief: Given a course code, the course with this arguments is 
	  * deleted from the curriculum of the academic program.   
	  * @@pre: Strings are valid     
	  * @@post: The course does no longer belongs to the curriculum of the academic program
	  * @@param: psCode
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes SUCCESS If everything is fine. 
	  */
	   public CodRes deleteCourseFromCurriculum(String psCode) 
	   {
		   if(psCode == "")
		   {
			   return CodRes.INVALID_ARGUMENTS; 
		   }
		   
		   CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		   return acaProg.deleteCourseCurriculum(psCode); 	
		   
	   }
	   
	  /**
	  * @@brief: Given a course code, the course with this argument is deleted from 
	  * the university.
	  * @@pre: String is valid     
	  * @@post: The course does no longer belongs to the university 
	  * @@param: psCode
	  * @@return: CodRes INVALID_ARGUMENTS If a parameter is not valid.
	  * @@return: CodRes SUCCESS If everything is fine. 
	  */
	   public CodRes deleteCourse(String psCode) 
	   {
		   if (psCode == "")
		   {
			   return CodRes.INVALID_ARGUMENTS;  
		   }
		   
		   CDepartment dept = getDepartment(sTempAcademicProg);
		   dept.deleteCourse(psCode);
		   return CodRes.SUCCESS;
	    
	   }
	   
	  /**
	  * @@brief: Given an student code, his information regarding    average grade, 
	  * credit number and course's taken is shown to user
	  * @@pre: The name is valid.     
	  * @@post: The arguments have the academic information for the student
	  * @@param: pnCode
	  * @@param: psCoursesSeen
	  * @@param: pfCreditNumber
	  * @@param: pfAverage
	  * @@return: CodRes
	  */
	   public CodRes showStudentAcademicInfo(int pnCode, String[][] psCoursesSeen, float pfCreditNumber, float pfAverage) 
	   {
		   if ( !isStudent())   //USER IS NOT STUDENT
		   {
			   return studentAdmin.showStudentAcademicInfo(pnCode, psCoursesSeen, pfCreditNumber, pfAverage);			   
		   }
		   else
		   {
			   return studentAdmin.showStudentAcademicInfo(nCodeStudent, psCoursesSeen, pfCreditNumber, pfAverage);	
		   }

	   }
	   
	  /**
	  * @@brief: Given an student code, his information regarding    apersonal data, 
	  * andr responsible data is shown to user
	  * @@pre: The name is valid.     
	  * @@post: The arguments have all the personal information for the student
	  * @@param: pnCode
	  * @@param: psPersonalData
	  * @@param: psResponsibleData
	  * @@return: CodRes
	  */
	   public CodRes showStudentPersonalInfo(int pnCode, ArrayList psPersonalData, ArrayList psResponsibleData) 
	   {
		   if ( !isStudent())   //USER IS NOT A STUDENT
		   {
			   return studentAdmin.showStudentPersonalInfo(pnCode, psPersonalData, psResponsibleData);			   
		   }
		   else
		   {
			   return studentAdmin.showStudentPersonalInfo(nCodeStudent, psPersonalData, psResponsibleData);	
		   }	    
	    
	   } 
	   
	  /**
	  * @@brief: Initialize the variable sTempAcademicProg when a Coordinator logs in.
	  * @@pre: The academic program is valid.  
	  * @@post: sTempAcademicProgram = Coordinator's Academic Program. 
	  * @@param: psLog
	  */
	  public void setSTempAcadProg(String psLog) 
	  {
	     sTempAcademicProg = psLog;		    
	  } 
	  
	  /**
	   * @@brief: Initialize the variable sTempAcademicProg when a Coordinator logs in.
	   * @@pre: The academic program is valid.       
	   * @@post: nCodeStudent = pnCode
	   * @@aditional_description: Only if the user is a student.
	   */
	  public void setCodeUserStudent( int pnCode)
	  {
		  nCodeStudent = pnCode;
	  }
	  
	  
	  /**
	   * @@brief: Get the principal info of the courses in the curriculum. 
	   * @@pre: arrSCodes and arrSNames are empty.   
	   * @@post: arrSCodes and arrSName have the codes and names of the courses in the curriculum.
	   * @@param: arrSCodes ArrayList of strings that have the codes of the courses.
	   * @@param: arrSNames ArrayList of strings that have the names of the courses.  
	   * @@aditional_description: The arrays are paralel.
	   */
	  public void getListOfCurriculumCourses (ArrayList arrSCodes, ArrayList arrSNames)
	  {
		  CAcademicProgram acaProg;
		  if ( !isStudent() )   //coordinator
		  {
			  acaProg = getAcademicProgram(sTempAcademicProg);
			  acaProg.getCurriculumCourses(arrSCodes, arrSNames);	 
		  }
		  else
		  {
			  String prog = studentAdmin.getMajor(nCodeStudent);
			  acaProg = getAcademicProgram(prog);
			  acaProg.getCurriculumCourses(arrSCodes, arrSNames);
		  }
	  }
	  
	  /**
	   * @@brief: Get the principal info of the department's courses 
	   * @@pre: The arrays are empty.    
	   * @@post: arrSCodes has the codes of the courses. arrSNames the courses' names.
	   * @@param: psDepto
	   * @@param: arrSCodes ArrayList of strings that have the codes of the courses.
	   * @@param: arrSNames ArrayList of strings that have the names of the courses.    
	   * @@aditional_description: The arrays are paralel.
	   */
	  public void getListDepartmentCourses (String psDepto, ArrayList arrSCodes, ArrayList arrSNames)
	  {
		  CDepartment depto;
		  if ( psDepto.equals(""))
		  {
			  depto = getDepartment(Integer.parseInt(sTempAcademicProg));
		  }
		  else
		  {
			  depto = getDepartment(psDepto);
		  }
		  
		  depto.getAllCourses (arrSCodes, arrSNames);		  
	  }
	  /**
	   * @@brief: Given a course code, it gets the prereqs of that course.  
	   * @@pre: pnCodeCourse is a valid code.     
	   * @@post: parrPrereqs has the codes of the prereqs.
	   * @@param: pnCodeCourse is the code of the course
	   * @@param: parrPrereqs'll have the codes of the prereqs.   
	   */
	  public void getListPrereqs (String pnCodeCourse, ArrayList parrPrereqs)
	  {
		  CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		  acaProg.getListPrereqs (pnCodeCourse, parrPrereqs);		  
	  }
	  
	  /**
	   * @@brief: Given a course code, it gets the prereqs of that course.    
	   * @@pre: pnCodeCourse is a valid code.      
	   * @@post: parrPrereqs has the codes of the prereqs.
	   * @@param: psCodeCourse
	   * @@param: nCodeCourse is the code of the course   
	   * @@aditional_description: parrPrereqs'll have the codes of the prereqs.
	   */
	  public void getListCoreqs (String pnCodeCourse, ArrayList parrCoreqs)
	  {
		  CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		  acaProg.getListCoreqs (pnCodeCourse, parrCoreqs);		  
	  }	  
	  
	  /**
	   * @@brief: Asks the Student administrator for the courses seen in a
	   *  given a semester of a student with a given code.  
	   * @@pre: True    
	   * @@post: Returns the info, if there's an error returns ERROR in [0][0].
	   * @@param: pnStudentCode The student's code.   
	   * @@param: pnSemester The semestre info we're looking for.
	   * @@return: String[][] The matrix.
	   */
	  public String[][] getCoursesAlreadySeenSemester(int pnStudentCode, int pnSemester)
	  {
		  if ( pnStudentCode < 197000000 || pnSemester < 1)
		  {
			  String[][] error = null;
			  error[0][0] = "ERROR";
			  return error;
		  }
		  else
		  {
			  return studentAdmin.getCoursesAlreadySeenSemester(pnStudentCode, pnSemester);
		  }
	  }
	  
	  /**
	   * @@brief: Gives all the existent faculties
	   * @@pre: True    
	   * @@post: Returns the all the faculties
	   * @@return: ArrayList
	   */
	  public ArrayList<CFaculty> getFaculties ( )
	{
		  return faculties;
	}
	  
	  /**
	   * @@brief: Gives the student administrator
	   * @@pre: True    
	   * @@post: The student administrator is given
	   * @@return: CStudentAdmin
	   */
	public CStudentAdmin getStudentAdmin ( )
	{
		  return studentAdmin;
	}

	  /**
	   * @@brief: Gives the course information
	   * @@pre: True    
	   * @@post: The course information is given
	   * @@param: code
	   * @@param: arrInfoCourse 0: Name, 1: Credits, 2: Level
	   */
	public void getInfoCourse(String code, ArrayList arrInfoCourse) 
	{
		String prog = "";
		CDepartment depto;
		int i = 0;
		CCourse course;
		Double cn;
		
		if ( !code.equals(""))
		{
			while ( i < 4 )
			{
				prog += code.charAt(i);
				i++;
			}
			
			depto = getDepartment(prog);
			course = depto.searchCourse(code);
			cn = course.getNCreditNumber();
			String cred = cn.toString();
			Integer icourse = course.getNLevel();
			String nLevel = icourse.toString();
			arrInfoCourse.add(course.getSName());
			arrInfoCourse.add(cred);
			arrInfoCourse.add(nLevel);			
		}		
	}
	
	 /**
	   * @@brief: Gives all the existent departments
	   * @@pre: True    
	   * @@post: Returns the all the departments
	   * @@param: ArrayList
	   */
	public void getListOfDepartments ( ArrayList arrDept )
	{
		Iterator it = faculties.iterator();
		CFaculty faculty;
		while ( it.hasNext())
		{
			faculty = (CFaculty)it.next();
			faculty.getListOfDepartments(arrDept);
		}
	}
	
	/**
	 * @@brief: Log In an user   
	 * @@pre: A user is not logged in
	 * @@post: If the users exists, he has been logged in
	 * @@param: psPassword the Password of the user
	 * @@param: psUserName the user's UserName   
	 * @@return: CodRes SUCCESS if the users has been logged in, USER_NOT_FOUND othherwise
	 */
	public CodRes LogIn (char[] cs, String psUserName)
	{
		if(theLoger.logInCoordinator(cs, psUserName)) {
			return CodRes.COORDINATOR;
		} else if(theLoger.logInCounselor(cs, psUserName)){
			return CodRes.ADVISOR;
		} else if(theLoger.logInStudent(cs, psUserName)){
			return CodRes.STUDENT;
		} else {
			return CodRes.USER_NOT_FOUND;
		}
	}
	
	/**
	 * @@brief: Log Out an user   
	 * @@pre: A user is logged in
	 * @@post: If the users exists, he has been logged out
	 */
	public void LogOut ( )
	{
		sTempAcademicProg = "";
		if ( nCodeStudent != 0)
		{
			cleanObservers();
		}
		nCodeStudent = 0;		
	}	

	/**
	 * @@brief: Save the current status of the world   
	 * @@pre: The world has something to be saved     
	 * @@post: World has been saved to disk
	 * @@param: void   
	 * @@return: CodRes Returns SUCCESS if the saving has been successful, ERROR otherwise	 
	 */
	public CodRes saveWorld ( )
	{
		//@TODO
		return CodRes.SUCCESS;
	}
	
	/**
	 * @@brief: Gives the login of a registed person    
	 * @@pre: true     
	 * @@post: The login of a registed person is given
	 * @@return: cLogin 
	 * @@aditional_description: none
	 */
	public CLogin getLogin ( )
	{
		return theLoger;
	}
	
	/**
	 * @@brief: Given a faculty name, this one is added   
	 * @@pre: The name is valid.    
	 * @@post: The faculty is added
	 * @@param: psName
	 * @@aditional_description: none  
	 */
	public void addFaculty (CFaculty faculty)
	{
		faculties.add(faculty);		
	}

	/**
	 * @@brief: Gives the existent areas    
	 * @@pre: true     
	 * @@post: The existent areas are given
	 * @@param: arrAreas Name of the different areas
	 * @@param: arrNumCourses Number of courses to see of the area
	 * @@aditional_description: none
	 */
	public void getListOfAreas (ArrayList arrAreas, ArrayList arrNumCourses)
	{
		CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		acaProg.getListAreas(arrAreas, arrNumCourses);		
	}
	
	/**
	 * @@brief: Gives the courses of a existent area    
	 * @@pre: The area exists    
	 * @@post: The courses of a existent areas are given
	 * @@param: psNameArea
	 * @@param: arrNumCourses 
	 * @@aditional_description: none
	 */
	public void getCoursesFromArea( String psNameArea, ArrayList nameCourses)
	{
		CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		acaProg.getAreaCourses(psNameArea, nameCourses);		
	}


	/**
	 * @@brief: Gives the the user student code    
	 * @@pre: The student exists    
	 * @@post: The user student code is given
	 * @@return: int 
	 */
	public int getUserStudentCode() 
	{		
		return nCodeStudent;
	}
	
	/**
	 * @@brief: Changes the name of the coordinator of a program   
	 * @@pre: The academic program with code psProgramCode exists
	 * @@post: The coordinator of that Academic Program is changed
	 * @@param: psProgramCode The code of the Academic Program
	 * @@param: psNewName The new name of the coordinator
	 * @@return: void
	 */
	public void changeCoordinatorOfAProgram (String psProgramCode, String psNewName)
	{
		(this.getAcademicProgram(psProgramCode)).setCoordinatorName(psNewName);
	}
	
	/**
	 * @@brief: Adds a course to the curriculum   
	 * @@pre: true
	 * @@post: If is possible adds the course to the curriculum and returns true or false depends the case
	 * @@param: psDode
	 * @@param: pnRow
	 * @@param: pnColumn
	 * @@return: boolean
	 */
	public CodRes addCourseToCurriculum(String psCode, int pnRow )
	{
		CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		return acaProg.addCourseToCurriculum(psCode, pnRow);		
	}
	
	/**
	 * @@brief: Removes a course to the curriculum   
	 * @@pre: true
	 * @@post: If is possible removes the course to the curriculum and returns true or false depends the case
	 * @@param: pnRow
	 * @@param: pnColumn
	 * @@return: boolean
	 */
	public CodRes removeCourseCurriculum(int pnRow, int pnColumn)
	{
		CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		return acaProg.removeCourseCurriculum(pnRow, pnColumn);		
	}
	
	/**
	 * @@brief: Moves a course in the curriculum   
	 * @@pre: true
	 * @@post: If is possible moves the course in the curriculum and returns true or false depends the case
	 * @@param: pnOldRow
	 * @@param: pnOldColumn
	 * @@param: bUp
	 * @@return: boolean
	 */
	public CodRes moveCourseCurriculum ( int pnOldRow, int pnOldColumn, boolean bUp)
	{
		CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
		return acaProg.moveCourseCurriculum(pnOldRow, pnOldColumn, bUp);		
	}
	
	/**
	 * @@brief: Gives the actual curriculum
	 * @@pre: the curriculum exist
	 * @@post: The actual curriculum is given
	 * @@param: none
	 * @@return: String [][] (Contain the courses of the curriculum)
	 */
	public String[][] getCurriculum ()
	{
		if ( isStudent() )
		{
			return studentAdmin.getStudentCurriculum(nCodeStudent);			
		}
		else
		{
			CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);		
			return acaProg.getCurriculum();
		}
	}
	
	/**
	 * @@brief: Gives the planned curriculum
	 * @@pre: the curriculum exist
	 * @@post: The planned curriculum is given
	 * @@param: none
	 * @@return: String [][] (Contain the courses of the curriculum)
	 */
	public String[][] getPlannedCurriculum()
	{
		return studentAdmin.getPlannedCurriculum(nCodeStudent);
	}
	
	/**
	 * @@brief: Send a message to a coordinator or an student  
	 * @@pre: True	
	 * @@post: The message is send to its destination
	 * @@param: codeStudent
	 * @@param: psTo = student or coordinator code
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@param: bFault
	 * @@return: CodRes (Indicates if the message has success or not)
	 */

	/*
	 * psTo = codigo de estudiante, si usuario es coordinador.
	 * 		= programa al que pertenece, si usuario es estudiante.
	 */
	public CodRes sendMessage( String psTo, String psSubject, String psMessage, boolean bFault)
	{
		CodRes res = CodRes.SUCCESS;
		
		if ( !isStudent() )  //It's a coordinator
		{
			Integer i = new Integer(psTo);
			int studCode = i;
			String user = getAcademicProgram(sTempAcademicProg).getCoordinator();
			if ( bFault )  //It's a fault.
			{
				if ( studentAdmin.sendDisciplinaryFault( user, psSubject, psMessage, studCode))
				{
					res = CodRes.SUCCESS;				
				}
				else
				{
					res = CodRes.INEXISTENT;
				}					
			}
			else  //It's a message
			{
				if ( studentAdmin.sendMessage( user, psSubject, psMessage, studCode))
				{
					res = CodRes.SUCCESS;				
				}
				else
				{
					res = CodRes.INEXISTENT;
				}					
			}
		}
		else //It's a student
		{
			CAcademicProgram acaProg = getAcademicProgram(psTo);
			acaProg.receiveMessage(nCodeStudent, psSubject, psMessage);
			
		}
		return res;		
	}
	
	/**
	 * @@brief: Gets the body of a message  
	 * @@pre: The body of the message exist	
	 * @@post: The body of the message is received
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the body of the message) 
	 */
	public ArrayList<String> getMessagesBody()
	{
		if ( !isStudent() )  //It's coordinator
		{
			CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
			return acaProg.getMessagesBody();			
		}
		else
		{
			return studentAdmin.getBodyOfMessages(nCodeStudent);
		}
	}
	
	/**
	 * @@brief: Gets the specific message  
	 * @@pre: The message exist	
	 * @@post: The especific message is received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificMessage( String psId )
	{
		if ( !isStudent())
		{
			CAcademicProgram acaProg = getAcademicProgram(sTempAcademicProg);
			return acaProg.getSpecificMessage(psId);			
		}
		else
		{
			return studentAdmin.getSpecificMessage(psId, nCodeStudent);
		}
				
	}

	/**
	 * @@brief: Adds a course to the planned curriculum
	 * @@pre: the curriculum exist
	 * @@post: A course is added to the planned curriculum
	 * @@param: psCourseCode
	 * @@param: pnSemester
	 * @@return: CodRes
	 */
	public CodRes addCourseToPlannedCurriculum(String psCourseCode,int pnSemester) 
	{
		ArrayList<String> ar = new ArrayList<String>();
		getInfoCourse(psCourseCode, ar);
		String name = ar.get(0);
		String cred = ar.get(1);
		//String level = ar.get(2);
		Float credit = new Float(cred);
		float credits = credit;
		return studentAdmin.addCourseToPlannedCurriculum( psCourseCode, name, credits, pnSemester, nCodeStudent);	
	}

	/**
	 * @@brief: Removes a course to the planned curriculum
	 * @@pre: the curriculum exist
	 * @@post: A course is removed to the planned curriculum
	 * @@param: pnRow
	 * @@param: pnColumn
	 * @@return: CodRes
	 */
	public CodRes removeCoursePlannedCurriculum(int pnRow, int pnColumn) 
	{		
		return studentAdmin.deleteCourseToSee(pnRow, pnColumn, nCodeStudent);
	}

	/**
	 * @@brief: Moves a course to the planned curriculum
	 * @@pre: the curriculum exist
	 * @@post: A course is moved to the planned curriculum
	 * @@param: pnOldRow
	 * @@param: pnOldColumn
	 * @@param: bUp
	 * @@return: CodRes
	 */
	public CodRes moveCoursePlannedCurriculum( int pnOldRow, int pnOldColumn, boolean bUp) 
	{
		return studentAdmin.moveCoursePlannedCurriculum( pnOldRow, pnOldColumn, bUp, nCodeStudent);
	}

	/**
	 * @@brief: Adds an observer to a prerrequirement
	 * @@pre: the prerrequirement exist
	 * @@post: an observer is added to a prerrequirement
	 * @@param: psCourse
	 * @@param: pnRow
	 * @@param: pnColumn
	 * @@param: area
	 * @@return: void
	 */
	public void addObserverProgramCurr(int pnRow, int pnColumn, Observer o) 
	{
		String prog;
		if ( isStudent() )
		{
			 prog = studentAdmin.getMajor(nCodeStudent);			
		}
		else
		{
			prog = sTempAcademicProg;				
		}		
		
		CAcademicProgram acaProg = getAcademicProgram(prog);
		CCurriculum curr = acaProg.getCurriculumObject();
		CCurriculumCourse obs = curr.getCourseObservable(pnRow, pnColumn);
		obs.addObserver(o);	
	}
	
	/**
	 * @@brief: Adds a new position to a given course. It�s used for the observer. 
	 * @@param pnRow row of the course to associate the observer.
	 * @@param pnColumn column of the course to associate the observer.
	 * @@param pnRowObs row of the observer.
	 * @@param pnColumnObs column of the observer
	 * @@param cPre true if it's a pre, false if it's a correq.
	 */
	public void addCourseObserver( int pnRow, int pnColumn, int pnRowObs, int pnColumnObs, boolean cPre )
	{
		String prog;
		if ( isStudent() )
		{
			 prog = studentAdmin.getMajor(nCodeStudent);			
		}
		else
		{
			prog = sTempAcademicProg;				
		}	
		CAcademicProgram acaProg = getAcademicProgram(prog);
		CCurriculum curr = acaProg.getCurriculumObject();
		CCurriculumCourse obs = curr.getCourseObservable(pnRow, pnColumn);
		if ( cPre)
			obs.addPreObserver(pnRowObs, pnColumnObs);
		else
			obs.addCorObserver(pnRowObs, pnColumnObs);
	}
	
	/**
	 * Activates the related courses of the course in position (pnRow, pnColumn)
	 * @@param psCourse Name of the courses
	 * @@param pnRow Position x in the matrix
	 * @@param pnColumn Position y in the matrix.
	 */
	public void turnOn(String psCourse, int pnRow, int pnColumn) 
	{
		String prog = (psCourse.split(" "))[0];
		CAcademicProgram acaProg = getAcademicProgram(prog);
		CCurriculum curr = acaProg.getCurriculumObject();
		CCurriculumCourse obs = curr.getCourseObservable(pnRow, pnColumn);
		obs.turnOnRelatedCourses();		
	}
	
	/**
	 * Cleans the arrays of observers (prereqs, coreqs) for all courses
	 */
	private void cleanObservers() 
	{
		CAcademicProgram acaProg = getAcademicProgram("");
		CCurriculum curr = acaProg.getCurriculumObject();
		curr.cleanObserver();				
	}
	
	/**
	 * Returns if is a student�s session or not.
	 * @@return if is a student�s session or not.
	 */
	private boolean isStudent()
	{
		return nCodeStudent != 0;
	}
	
	public boolean canGraduate()
	{		
		return studentAdmin.verifyEndOfCareer(nCodeStudent);
	}	
}