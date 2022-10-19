/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CBannerLinker.java 
 * @@brief    
 * @@version  1.1
 * @@date     21-mar-2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     Serialize with StringBuffer.
 * @@bug      19/05/2006 Fixed bug that caused a bad serialization on departments
 */

//--------- Present package declaration
package coursemanager.model;

//--------- Standar Libraries import
import java.util.ArrayList;
import java.util.Iterator;

import coursemanager.persistence.FacultyFields;
import coursemanager.persistence.LoadFileUtility;

//--------- Own libraries import 

// -------- Class declaration and documentation

/**<br> This class manages the faculty information such as the faculty name 
	      and its associated departments <\br>
 * @@invariant: There are no two faculties with the same name.   
 * @@par:  	
 */
public class CFaculty {
	private Integer Id;

	/**
	 * A list with the departments of the faculty
	 */
	private ArrayList<CDepartment> arlDepartments;

	/**
	 * String name of the faculty
	 */
	private String sName;

	/**
	 * Class constructor
	 * @@pre: sName is not NULL.
	 * @@pos: Creates a faculty with name psName.
	 */
	public CFaculty(String psName) 
	{
		arlDepartments = new ArrayList<CDepartment>();
		sName = psName;
	}

	/**
	 * Class constructor
	 * @@pre: true
	 * @@pos: Creates a faculty.
	 */
	public CFaculty() 
	{
		arlDepartments = new ArrayList<CDepartment>();
	}

	public Integer getId()
	{
		return Id;
	}

	public void setId(Integer id)
	{
		Id = id;
	}

	public ArrayList<CDepartment> getDepartments()
	{
		return arlDepartments;
	}

	public void setDepartments(ArrayList<CDepartment> arlDepartments)
	{
		this.arlDepartments = arlDepartments;
	}

	public String getName()
	{
		return sName;
	}

	public void setName(String sName)
	{
		this.sName = sName;
	}

	/**
	 * @@brief: This method returns an academic program given its name   
	 * @@pre: The name most be a valid string     
	 * @@post: The academic program is returned if the name corresponds to an 
	 *		   academic program. Other wise the value returne is NULL.
	 * @@param: psAcademicProgram
	 * @@return: CAcademicProgram
	 * @@aditional_description: none 
	 */
	public CAcademicProgram getAcademicProgram(String psAcademicProgram) 
	{
		for(CDepartment department : arlDepartments) {
			if(department.getAcademicProgram(psAcademicProgram) != null)
				return  department.getAcademicProgram(psAcademicProgram);
		}
		return null;		
	}

	/**
	 * @@brief: This method returns a department that contains an academic program given its name   
	 * @@pre: The name most be a valid string     
	 * @@post: The department is returned if the name corresponds to an 
	 *		   academic program in the department. Other wise the value returne is NULL.
	 * @@param: psAcademicProgram
	 * @@return: CDepartment 
	 */
	public CDepartment getDepartment(Integer depId) 
	{
		for(CDepartment department : arlDepartments)
		{
			if(department.getId().equals(depId))
				return department;			   
		}
		return null;
	}

	/**
	 * @@brief: This method returns a department that contains an academic program given its name   
	 * @@pre: The name most be a valid string     
	 * @@post: The department is returned if the name corresponds to an 
	 *		   academic program in the department. Other wise the value returne is NULL.
	 * @@param: psAcademicProgram
	 * @@return: CDepartment 
	 */
	public CDepartment getDepartmentFromAcadProg(String psAcademicProgram) 
	{
		for(CDepartment department : arlDepartments)
		{
			CAcademicProgram acaProg = department.getAcademicProgram(psAcademicProgram);
			if(acaProg != null)
				return department;
		}
		return null;	   
	}

	/**
	 * @@brief: This method is in charge of adding, given the a name, a new 
	 *		   department ino the faculty.   
	 * @@pre: The name of the department most be valid and not repeated in any other 
	 *		 of the faculties.   
	 * @@post: A new department is created into the faculty if and only if there is 
	 *	      no other department with the same name within the university. 
	 * @@param: psName
	 * @@return: CodRes 
	 * @@aditional_description: none
	 */
	public CodRes addDepartment(Integer id) 
	{
		for(CDepartment department : arlDepartments) {
			if(department.getId().equals(id)) {
				return CodRes.SUCCESS;
			}
		}
		CDepartment newDept = new CDepartment();
		newDept.setId(id);
		arlDepartments.add(newDept);
		return CodRes.SUCCESS;
	}

	/**
	 * @@brief: Gives all facultie's departments  
	 * @@pre: the faculty exist
	 * @@post: The facultie`s depatrments are given
	 * @@param: arrDept  
	 * @@aditional_description: none
	 */
	public void getListOfDepartments(ArrayList<CDepartment> arrDept) 
	{
		arrDept.clear();
		arrDept.addAll(arlDepartments);			
	}

	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlDepartments != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize ( )
	{
		String sTemp = sName+"\n";
		int nTam = arlDepartments.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CDepartment)arlDepartments.get(i)).getName() +"\n";
		}
		sTemp += "end\n";//Remember. Use println. 19/05/06 I did not. Auch
		return sTemp;
	}

	/**
	 * @@brief: Returns a String with the serialization of all the departments, in the format defined   
	 * @@pre: arlDepartments != null       
	 * @@post: A String containing the serialized departments is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeDepartments ( )
	{
		String sTemp = "";
		int nTam = arlDepartments.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CDepartment)arlDepartments.get(i)).serialize() +"\n";
		}		
		return sTemp;
	}

	/**
	 * @@brief: Returns a String with the serialization of all the academic programs of this faculty, in the format defined   
	 * @@pre: arlDepartments != null       
	 * @@post: A String containing the serialized programs is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeAcademicPrograms ( )
	{
		String sTemp = "";
		int nTam = arlDepartments.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CDepartment)arlDepartments.get(i)).serializeAcademicPrograms();
		}
		//sTemp += "\n";//Remember. Use println.
		return sTemp;
	}

	/**
	 * 
	 * @@brief: Returns a String with the serialization of all the Messages   
	 * @@pre: arlDepartments != null       
	 * @@post: A StringBuilder containing the serialized messages is returned, null otherwise 
	 * @@param: void   
	 * @@return: StringBuilder Contains the serialized object
	 */
	public StringBuilder serializeCoordinatorMessages ( )
	{
		StringBuilder sbTemp = new StringBuilder();
		int nTam = arlDepartments.size();
		for(int i = 0; i < nTam; i++)
		{
			sbTemp.append(((CDepartment)arlDepartments.get(i)).serializeCoordinatorMessage());
		}		
		return sbTemp;
	}

	/**
	 * @param string
	 * @param string2
	 */
	public void assignFacultyFieldWithData(String label, String value)	{
		if(label.equals(FacultyFields.getFieldName(FacultyFields.ITEM_ID))){
			setId(Integer.parseInt(value));
		} else if(label.equals(FacultyFields.getFieldName(FacultyFields.NAME))){
			setName(value);
		}else if(label.equals(FacultyFields.getFieldName(FacultyFields.DEPARTMENTS))){
			String[] departments = value.split(",");
			addDepartmentsFaculty(departments);			
		}	
	}

	private void addDepartmentsFaculty(String[] departments) {
		for(String departmentId : departments) {
			for(CDepartment department : LoadFileUtility.getDepartments()) {
				if(department.getId().intValue() == Integer.parseInt(departmentId)) {
					arlDepartments.add(department);
				}
			}
		}
	}
}