/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CDepartment.java 
 * @@brief    
 * @@version  1.0
 * @@date     22-mar-2006
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
import java.util.Iterator;

import coursemanager.persistence.DepartmentFields;
import coursemanager.persistence.LoadFileUtility;


//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> The representation of a department <\br>
 * @@invariant: There are not two departments with the same name within a same faculty.
 * 			   The courses offered by the department have like beginning of code, 
 *             the code of the department.   
 */
public class CDepartment {

	private Integer id;

	private Integer facultyId;

	/**
	 * ArrayList with the academic programs offered by the department
	 */
	private ArrayList<CAcademicProgram> arlPrograms;

	/**
	 * Department's name
	 */
	private String sName;

	/**
	 * ArrayList with the courses offerd by department
	 */
	private ArrayList<CCourse> arlCourses;

	public CDepartment() {
		arlPrograms = new ArrayList<CAcademicProgram>();
		arlCourses = new ArrayList<CCourse>();
	}
	/**
	 * Class constructor
	 */
	public CDepartment(String psName) 
	{
		arlPrograms = new ArrayList<CAcademicProgram>();
		arlCourses = new ArrayList<CCourse>();
		sName = psName;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public ArrayList<CAcademicProgram> getPrograms()
	{
		return arlPrograms;
	}
	public void setPrograms(ArrayList<CAcademicProgram> arlPrograms)
	{
		this.arlPrograms = arlPrograms;
	}
	public String getName()
	{
		return sName;
	}
	public void setName(String sName)
	{
		this.sName = sName;
	}
	public ArrayList<CCourse> getCourses()
	{
		return arlCourses;
	}
	public void setCourses(ArrayList<CCourse> arlCourse)
	{
		this.arlCourses = arlCourse;
	}

	public Integer getFacultyId()
	{
		return facultyId;
	}
	public void setFacultyId(Integer facultyId)
	{
		this.facultyId = facultyId;
	}
	/**
	 * @@brief: Creates a new academic program for the department and is added to 
	 * 		  the ArrayList.
	 * @@pre:   String is valid.    
	 * @@post:  The academic program now belongs to the department
	 * @@param:  psName
	 * @@param: psCode
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public CodRes addAcademicProgram(String psName, String psCode) 
	{
		CAcademicProgram acaProg = new CAcademicProgram(psName, psCode);
		if ( getAcademicProgram(psCode) != null )
		{
			return CodRes.ALREADY_EXISTS;
		}
		else
		{
			arlPrograms.add(acaProg);
			return CodRes.SUCCESS; 	 			   
		} 
	}

	/**
	 * @@brief: Creates a new course for the department and is added to the 
	 * 		  ArrayList after verification of arguments.
	 * @@pre: Strigns are valid, level and credit number are grater than 0.    
	 * @@post: The course is added to the department if no other course sahre the 
	 * 		 same code.  
	 * @@param: psName
	 * @@param: psCode
	 * @@param: pfCreditNumber
	 * @@param: pnLevel
	 * @@param: psType
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public CodRes addCourse(String psName, String psCode, float pfCreditNumber, int pnLevel, String psType) 
	{
		if (searchCourse(psCode) != null )
		{
			return CodRes.ALREADY_EXISTS; 
		}
		else
		{
			CCourse newCourse = new CCourse(psName, psCode, pfCreditNumber, pnLevel, psType);
			arlCourses.add(newCourse);
			return CodRes.SUCCESS;  
		}    
	}  

	/**
	 * @param course
	 */
	public void addCourse(CCourse course)
	{
		arlCourses.add(course);
	}

	/**
	 * @@brief: Sets the info given to the course with given name 
	 * @@pre: True     
	 * @@post: the info of the course is changed
	 * @@param: psName
	 * @@param: pnNumCredits
	 * @@param: psCode
	 * @@param: pnLevel
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public CodRes setInfoCourse(String psName, float pnNumCredits, String psCode, int pnLevel) 
	{
		CCourse course = searchCourse(psCode);
		if (course == null)
		{
			return CodRes.INEXISTENT; 
		}
		else
		{
			course.set(psName, pnNumCredits, pnLevel);
			return CodRes.SUCCESS; 
		}
	}

	/**
	 * @@brief: Returns the academic program of a department given its name.    
	 * @@pre: string is valid.     
	 * @@post: The academic program is returned if exist an academic program with 
	 * 		 the name given within the department. If ther is not such an academic program 
	 * 		 the methos returns NULL.
	 * @@param: psName
	 * @@return: CAcademicProgram 
	 * @@aditional_description: none  
	 */
	public CAcademicProgram getAcademicProgram(String psNameCode) 
	{
		Iterator it = arlPrograms.iterator();
		CAcademicProgram acaProg = null;
		boolean found = false;

		while(it.hasNext() && !found)
		{
			acaProg = (CAcademicProgram)it.next();
			if (acaProg.getNameCode().equals(psNameCode))			   
			{
				found = true;
			}
		}
		if (found)
		{
			return acaProg;			   
		}
		else
		{
			return null;
		}	    
	}

	/**
	 * @@brief: Given a course code method retrives  a course. If exist for this 
	 * 		  department
	 * @@pre: The string is valid.    
	 * @@post: The course is return if the coude corresponds to a course offerd by 
	 * 	     the department. returns NULL otherwise
	 * @@param: psCode
	 * @@return: CCourse
	 * @@aditional_description: none  
	 */
	public CCourse searchCourse(String psCode) 
	{
		Iterator it = arlCourses.iterator();
		boolean found = false;
		CCourse course = null;

		while (!found && it.hasNext())
		{
			course = (CCourse)it.next();
			if (course.getSCode().equals(psCode))
			{
				found = true;
			}			   
		}
		if (found)
		{
			return course;
		}
		else
		{
			return null;
		}	       
	}

	/**
	 * @@brief: Given a code method deletes a course. If code dose not correspond to 
	 * 		  any course the nothing happends
	 * @@pre: The string is valid.    
	 * @@post: The course is deleted from the department* 
	 * @@param: psCode
	 * @@aditional_description: none  
	 */
	public CodRes deleteCourse(String psCode) 
	{
		CCourse courseToRemove = searchCourse(psCode);
		if (courseToRemove == null)
		{
			return CodRes.ERROR; 
		}
		else
		{
			arlCourses.remove(courseToRemove);
			return CodRes.SUCCESS;
		}			   
	}

	/**
	 * @@brief:  Get the name and codes of all the department's courses. 
	 * @@pre: The arrays are empty.    
	 * @@post: The respective info is loaded in the arrays.
	 * @@param: arrSCodes Array of courses' codes.  
	 * @@return: arrSNames Array of courses' names.
	 * @@aditional_description: Arrays are paralel.
	 */   
	public void getAllCourses(ArrayList<String> arrSCodes, ArrayList<String> arrSNames) 
	{
		for(CCourse course : arlCourses) {
			arrSCodes.add(course.getSCode());
			arrSNames.add(course.getSName());			
		}		
	}

	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, sNameCode != null, arlStudent != null, curriculu != null, rulesAdmin != null, sCoordinator != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize ( )
	{
		String sTemp = sName+"\n";
		int nTam = arlPrograms.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CAcademicProgram)arlPrograms.get(i)).getName() +"\n"+((CAcademicProgram)arlPrograms.get(i)).getNameCode()+"\n";
		}
		sTemp += "end1\n";//Auch
		nTam = arlCourses.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CCourse)arlCourses.get(i)).serialize()+"\n";
		}
		sTemp += "end2";//Remember. Use println.
		return sTemp;
	}

	/**
	 * @@brief: Returns a String with the serialization of the academic programs, in the format defined   
	 * @@pre: arlPrgrams!=null       
	 * @@post: A String containing the serialized object is returned, "" otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeAcademicPrograms ( )
	{
		String sTemp = "";
		int nTam = arlPrograms.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CAcademicProgram)arlPrograms.get(i)).serialize()+"\n";
		}		
		return sTemp;
	}

	/**
	 * 
	 * @@brief: Returns a String with the serialization of all the Messages   
	 * @@pre: arlPrograms != null       
	 * @@post: A StringBuilder containing the serialized messages is returned, null otherwise 
	 * @@param: void   
	 * @@return: StringBuilder Contains the serialized object
	 */
	public StringBuilder serializeCoordinatorMessage ( )
	{
		StringBuilder sbTemp = new StringBuilder(); 
		int nTam = arlPrograms.size();
		for(int i = 0; i < nTam; i++)
		{
			sbTemp.append(((CAcademicProgram)arlPrograms.get(i)).serializeMessages()) ;
		}		
		return sbTemp;
	}

	/**
	 * @@brief: Gets the actual programs   
	 * @@pre: The programs exist      
	 * @@post: The list of rograms is given 
	 * @@param: ArrayList programs  
	 * @@return: void 
	 * @@aditional_description: none
	 */
	public ArrayList<String> getListOfPrograms() 
	{
		ArrayList<String> progCodes = new ArrayList<String>();
		for(CAcademicProgram program : arlPrograms)
		{
			progCodes.add(program.getNameCode());
		}		
		return progCodes;
	}

	/**
	 * @param string
	 * @param string2
	 */
	public void assignDepartmentFieldWithData(String label, String value)
	{
		if(label.equals(DepartmentFields.getFieldName(DepartmentFields.ITEM_ID))){
			setId(Integer.parseInt(value));
		} else if(label.equals(DepartmentFields.getFieldName(DepartmentFields.NAME))){
			setName(value);
		}else if(label.equals(DepartmentFields.getFieldName(DepartmentFields.FACULTY))){
			setFacultyId(Integer.parseInt(value));
		}else if(label.equals(DepartmentFields.getFieldName(DepartmentFields.COURSES))){
			String[] courses = value.split(",");
			addCoursesDepartment(courses);			
		}else if(label.equals(DepartmentFields.getFieldName(DepartmentFields.PROGRAMS))){
			String[] programs = value.split(",");
			addProgramsDepartment(programs);	
		}					
	}

	private void addCoursesDepartment(String[] courses) {
		for(String courseCode:courses) {
			for(CCourse course : LoadFileUtility.getCourses()) {
				if(courseCode.equals(course.getSCode())) {
					arlCourses.add(course);
				}
			}
		}
	}
	
	private void addProgramsDepartment(String[] programNames) {
		for(String name : programNames) {
			for(CAcademicProgram program : LoadFileUtility.getAcademicPrograms()) {
				if(name.equals(program.getName())) {
					arlPrograms.add(program);
				}
			}
		}
	}
}