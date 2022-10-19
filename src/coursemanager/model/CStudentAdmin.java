/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CStudentAdmin.java 
 * @@brief    
 * @@version  1.0
 * @@date     24/03/2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.model;

//--------- Standar Libraries import
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Iterator;


//--------- Own libraries import 


// -------- Class declaration and documentation


/**<br> Class that manages the students in the system. <\br>
 * @@invariant: Class contains all students register.
 */
public class CStudentAdmin {
	/**
	 * HashTable with the students. 
	 */ 
	private Hashtable hatStudents;
	
	/**
	 * Constructor
	 * pre: true.
	 * pos: Creates a student administrator.
	 */    
	public CStudentAdmin() 
	{
		hatStudents = new Hashtable();		
	}
	
	/**
	 * @@brief: Given a code it verifies if exists a student with that code.
	 * @@pre: code > 197010000
	 * @@post: return if the student exists.
	 * @@param: pnCode Code of the student.
	 * @@return: boolean
	 */
	public boolean verifyIFAStudentExists(int pnCode) 
	{	
		CStudent tempStud = getStudent(pnCode);
		return ( tempStud != null);
	}
	
	/**
	 * @@brief: Given a code, modifies the personal info of a student.
	 * @@pre: The info is valid.
	 * @@post: The personal info of a student which code is pnCode has been modified.
	 * If a parameter is NULL that atribute is not modified.
	 * @@param: pnCode Code of the student.
	 * @@param: psNewTel New phone number.
	 * @@param: psNewResponsible New responsible.
	 * @@param: psNewResTel New responsible's phone number.
	 * @@return: CodRes
	 */
	public CodRes modifyStudentPersonalInfo(int pnCode, String psTelNum, String psAddress, String psEmail, String psResponsibleName, String psResponsibleTel) 
	{
		CStudent stud = getStudent(pnCode);
		if ( stud == null )
		{
			return CodRes.INEXISTENT;
		}
		else
		{
			stud.setPersonalInfo (psTelNum, psAddress, psEmail, psResponsibleName, psResponsibleTel);	
			return CodRes.SUCCESS;
		}
		
	}
	
	/**
	 * @@brief: Given a code, modifies the academic info of a student.
	 * @@pre: The info is valid.
	 * @@post: The academic info of a student which code is pnCode has been modified.
	 * If a parameter is NULL that atribute is not modified.
	 * @@return: CodRes
	 */
	public CodRes modifyStudentAcademicInfo(int pnNCode, String psCourses, int pnSemester, float pfCreditNum, String psComments) 
	{
		return CodRes.INEXISTENT;
	}
	
	/**
	 * @@brief: A new student is created with the atributes given by parameter.
	 * @@pre: The info is valid. None parameter is NULL.
	 * @@post: A student is created and added into the HashTable
	 * @@param: psName Name of the student.
	 * @@param: psLastName Last name of the student.
	 * @@param: psAddr Address of the student.
	 * @@param: psTel Phone number of the student.
	 * @@param: psParent Parent of the student.
	 * @@param: psParTel Phone number of the student's parent.
	 * @@param: currToSee Curriculum to see.
	 * @@param: psAcademicProgram Academic Program of the student.
	 * @@return: CStudent
	 */
	public CStudent addStudent(String psName, String psLastName, int pnCode, String psEmail, String psTypeID, 
			String psID, String psAddr, String psTelNum, String psResponsibleName, String psResponsibleTel, 
			String psAcadProgCode, CCurriculum currToSee) 
	{
		CStudent newStudent = new CStudent(psName, psLastName, pnCode, psEmail, psTypeID, psID, psAddr, psTelNum, psResponsibleName, psResponsibleTel, psAcadProgCode, currToSee);
		boolean exists = hatStudents.contains(newStudent);
		if ( exists )
		{
			return null;
		}
		else
		{
			Integer i = new Integer (pnCode);
			String sCode = i.toString();
			hatStudents.put(sCode, newStudent);
			return newStudent;
		}		
	}
	
	/**
	 * @@brief: Given a student's code, it returns the personal info of the student.
	 * @@pre: pnCode is not NULL.
	 * @@post: it returns the personal info of the student.
	 * @@param: pnCode Code of the student.
	 * @@param: psPersonalData Personal info of the student.
	 * @@param: psResponsibleData Personal info of the student's responsible.
	 * @@return: CodRes
	 */
	public CodRes showStudentPersonalInfo(int pnCode, ArrayList psPersonalData, ArrayList psResponsibleData) 
	{
		CStudent stu = getStudent(pnCode);
		String name =  stu.getName();
		String lastName =  stu.getLastName();
		String address =   stu.getAddress();
		String telephone =  stu.getStudentTelNum();
		String typeDocument = stu.getSTypeID();
		int c = stu.getCode();
		Integer i = c;
		String code = i.toString();
		String mail =  stu.getEmail();
		String responsibleName =  stu.getResponsibleName();
		String responsibleTelephone =  stu.getResponsibleTelNumber();
		psPersonalData.add(name);
		psPersonalData.add(lastName);
		psPersonalData.add(address);
		psPersonalData.add(telephone);
		psPersonalData.add(mail);
		psPersonalData.add(code);
		psPersonalData.add(typeDocument);
		psPersonalData.add(stu.getID());
		psResponsibleData.add(responsibleName);
		psResponsibleData.add(responsibleTelephone);

		return CodRes.SUCCESS;
	}
	
	/**
	 * @@brief: Given a student's code, it returns the academic info of the student.
	 * @@pre: pnCode is not NULL.
	 * @@post: it returns the academic info of the student.
	 * @@param: psCoursesSeen Courses seen by the student by semester.
	 * @@param: pfCreditNumber Number of credits seen by the student
	 * @@param: pfAverage Average of the student.
	 * @@return: CodRes
	 */
	public CodRes showStudentAcademicInfo(int pnCode, String[][] psCoursesSeen, float pfCreditNumber, float pfAverage) 
	{
		return null;		
	}
	
	/**
	 * @@brief: Given a student's code, it returns the student's name.
	 * @@pre: pnCode is not NULL.
	 * @@post: it returns the name of the student.
	 * @@param: pnCode Student's code.
	 * @@return: string
	 */
	public String userNameFromACode(int pnCode) 
	{		
		CStudent student = getStudent(pnCode);
		return student.getNameAndLastName();		
	}
	
	/**
	 * @@brief: Asks to the student with a given code for the seen courses.   
	 * @@pre: pnStudentCode > 19700000. Semestrer > 0.     
	 * @@post: Returns a matrix with the info of the seen courses.
	 * @@param: pnStudentCode The student's code.   
	 * @@param: pnSemester The semestre info we're looking for.
	 * @@return: String[][] The matrix.
	 */
	public String[][] getCoursesAlreadySeenSemester(int pnStudentCode, int pnSemester)
	{
		CStudent stud = getStudent(pnStudentCode);
		if ( stud == null )
		{
			String error[][] = null;
			error[0][0] = "ERROR";
			return error;
		}
		else
		{
			return stud.getCoursesAlreadySeenSemester(pnSemester);			
		}		
	}
	
	/**
	 * @@brief: Gets a student given his/her code.   
	 * @@pre: True.    
	 * @@post: Returns the student.
	 * @@param: pnCode Student's code.  
	 * @@return: CStudent The student with code = pnCode.
	 */
	private CStudent getStudent(int pnCode)
	{
		Integer i = new Integer(pnCode);		
		String sCode = i.toString();
		CStudent stud = (CStudent) hatStudents.get(sCode);
		return stud;		
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: hatStudents != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize ( )
	{
		String sTemp = "";
		Collection colObject = hatStudents.values();
		Iterator it = colObject.iterator();
		while(it.hasNext())
		{
			sTemp += ((CStudent)it.next()).serialize()+"\n";
		}		
		return sTemp;
	}
	
	/**
	 * @@brief: Returns a StringBuilder with the serialization of this class, in the format defined   
	 * @@pre: hatStudents != null
	 * @@post: A StringBuilder containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: StringBuilder Contains the serialized object
	 */
	public StringBuilder serializeVirtualFolders ( )
	{
		StringBuilder sbTemp = new StringBuilder();
		Collection colObject = hatStudents.values();
		Iterator it = colObject.iterator();
		while(it.hasNext())
		{
			sbTemp.append(((CStudent)it.next()).serializeVirtualFolder());
			sbTemp.append('\n');//is it necessary?
		}		
		return sbTemp;
	}
	
	/**
	 * @@brief: Gives the actual curriculum of the student 
	 * @@pre: The curriculum exist       
	 * @@post: The curriculum of the student is given 
	 * @@param: pnStudentCode
	 * @@return: String [][] (Contain the courses of the student curriculum) 
	 * @@aditional_description: none
	 */
	public String[][] getStudentCurriculum( int pnStudentCode )
	{ 
		CStudent stud = getStudent( pnStudentCode );
		return stud.getCurriculum();
	}
	
	/**
     * @@brief: Adds to a student a course to see   
     * @@pre: The course and the student exist    
     * @@post: If is possible the course is added
     * @@param: psCode
     * @@param: sName
     * @@param: pfCred 
     * @@param: pnSemester
     * @@param: pnStudentCode
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public CodRes addCourseToSee ( String psCode, String psName, float pfCred, int pnSemester, int pnStudentCode)
	{
		CStudent stud = getStudent( pnStudentCode );
		return stud.addCourseToSee(psCode, psName, pfCred, pnSemester);
	}
	
	/**
     * @@brief: Deletes to a student a course to see   
     * @@pre: The course and the student exist    
     * @@post: If is possible the course is eliminated
     * @@param: psCode
     * @@param: pnSemester
     * @@param: pnStudentCode
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public CodRes deleteCourseToSee ( int pnSemester,int pnColumn, int pnStudentCode)
	{
		CStudent stud = getStudent( pnStudentCode );
		return stud.deleteCourseToSee( pnSemester, pnColumn);
	}
	
	/**
     * @@brief: Verifies if a student ends his career   
     * @@pre: The student exist   
     * @@post: You know if a student realy finish his career
     * @@param: pnStudentCode
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public boolean verifyEndOfCareer( int pnStudentCode)
	{
		CStudent stud = getStudent( pnStudentCode );
		return stud.verifyEndOfCareer();
	}
	
	/**
	 * @@brief: Gets the specific message from a student 
	 * @@pre: The message and the student exist	
	 * @@post: The especific message is received
	 * @@param: psId
	 * @@param: pnStudentCode
	 * @@return: String 
	 */
	public String getSpecificMessage ( String psId, int pnStudentCode)
	{
		CStudent stud = getStudent( pnStudentCode );
		return stud.getSpecificMessage(psId);
	}

	/**
	 * @@brief: Sends a message to a student  
	 * @@pre: The message exist	
	 * @@post: The message is sended
	 * @@param: psUser
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@param: pnStudentCode
	 * @@return: boolean 
	 */
	public boolean sendMessage(String psUser, String psSubject, String psMessage, int pnStudentCode) 
	{
		CStudent stud = getStudent( pnStudentCode );
		boolean found = true;
		if ( stud == null )
		{
			found = false;
		}
		else
		{
			stud.receiveMessage( psUser, psSubject, psMessage);
		}
		return found;
	}
	
	/**
	 * @@brief: Gets the body of the messages  
	 * @@pre: The body of the messages exist	
	 * @@post: The body of the messages are received
	 * @@param: pnStudentCode
	 * @@return: ArrayList<String> (Contain the body of the messages) 
	 */
	public ArrayList<String> getBodyOfMessages( int pnStudentCode )
	{
		CStudent stud = getStudent( pnStudentCode );
		return stud.getMessagesBody();		
	}

	/**
	 * @@brief: Sends a fault of a student  
	 * @@pre: True
	 * @@post: If the student exist, the fault is sended.
	 *        Indicates true or false as a result of the operation.
	 * @@param: psUser
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@param: pnStudentCode
	 * @@return: boolean 
	 */
	public boolean sendDisciplinaryFault(String psUser, String psSubject, String psMessage, int pnStudentCode ) 
	{
		CStudent stud = getStudent( pnStudentCode );
		boolean found = true;
		if ( stud == null )
		{
			found = false;
		}
		else
		{
			stud.receiveFault( psUser, psSubject, psMessage);
		}
		return found;
		
	}

	/**
	 * @@brief: Gets the planned curriculum  
	 * @@pre: True	
	 * @@post: The planned curriculum is given
	 * @@param: pnStudentCode
	 * @@return: String [][] 
	 */
	public String[][] getPlannedCurriculum(int pnStudentCode) 
	{
		CStudent stud = getStudent(pnStudentCode);
		return stud.getPlannedCurriculum();
	}

	/**
	 * @@brief: Gets the student mayor  
	 * @@pre: True	
	 * @@post: The student mayor is given
	 * @@param: pnStudentCode
	 * @@return: String 
	 */
	public String getMajor(int pnStudentCode) 
	{
		CStudent stud = getStudent(pnStudentCode);
		return stud.getMajor();
	}

	/**
	 * @@brief: Adds a course to the planned curriculum  
	 * @@pre: The curriculum exist	
	 * @@post: A course is added to the planned curriculum
	 * @@param: psCourseCode
	 * @@param: psName
	 * @@param: pfCred
	 * @@param: pnSemester
	 * @@param: pnStudentCode
	 * @@return: CodRes 
	 */
	public CodRes addCourseToPlannedCurriculum(String psCourseCode, String psName, float pfCred, int pnSemester, int pnStudentCode) 
	{
		CStudent stud = getStudent(pnStudentCode);
		return stud.addCourseToPlannedCurriculum(psCourseCode, psName, pfCred, pnSemester);
	}
	
	/**
	 * @@brief: Moves a course to the planned curriculum  
	 * @@pre: The curriculum exist	
	 * @@post: A course is moved to the planned curriculum
	 * @@param: pnOldRow
	 * @@param: pnOldColumn
	 * @@param: bUp
	 * @@param: pnStudentCode
	 * @@return: CodRes 
	 */
	public CodRes moveCoursePlannedCurriculum(int pnOldRow, int pnOldColumn, boolean bUp, int pnStudentCode) 
	{
		CStudent stud = getStudent(pnStudentCode);
		return stud.changeSemesterOfACourse(pnOldRow, pnOldColumn, bUp);
	}
}