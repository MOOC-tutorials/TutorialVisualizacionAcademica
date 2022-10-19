/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CLogin.java 
 * @@brief    Constains the eclaration of the CLogin class
 * @@version  1.0
 * @@date     22-mar-2006
 * @@author   CriolloSoft
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.model;

//--------- Standard Libraries import
import java.util.ArrayList;
import java.util.Arrays;

import coursemanager.controller.CManager;

//--------- Own libraries import 


// -------- Class declaration and documentation



/**<br> Manages requests from the world about the username and password of different users of the system. <\br>
 * @@invariant: 
 */
public class CLogin {
	
	/**
	Array with the students Login
	 */
	private ArrayList<CLogStu> arlStudentsLogin;
	
	/**
	Array with the coordinators Login
	 */
	private ArrayList<CLogCoor> arlCoordinatorsLogin;
	
	/**
	Array with the councelors Login
	 */
	private ArrayList<CLogCouns> arlCounselorsLogin;
	
	/**
	 * A refernce to the manager, needed to set the academic program of the coordinator
	 */
	private CManager manager;
	
	/**
	 * Class constructor
	 */
	public CLogin(CManager manager) 
	{
		arlStudentsLogin = new ArrayList<CLogStu>();
		arlCoordinatorsLogin = new ArrayList<CLogCoor>();
		arlCounselorsLogin = new ArrayList<CLogCouns>();
		this.manager = manager;
	}
	
	/**
	 * @@brief: Verify if a given password and user name of a student are valid  
	 * @@pre: True
	 * @@post: The password and user name are verified
	 * @@param: psPassword
	 * @@param: psUserName  
	 * @@return: boolean
	 * @@aditional_description: none
	 */
	public boolean logInStudent (char[] psPassword, String psUserName)
	{
		for(CLogStu student: arlStudentsLogin) {
			if(student.getUserName().equals(psUserName) && Arrays.equals(psPassword, student.getPassword().toCharArray())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @@brief: Verify if a given password and user name of a counselor are valid  
	 * @@pre: True
	 * @@post: The password and user name are verified
	 * @@param: psPassword
	 * @@param: psUserName  
	 * @@return: boolean
	 * @@aditional_description: none
	 */
	public boolean logInCounselor (char[] psPassword, String psUserName)
	{
		for(CLogCouns cons: arlCounselorsLogin) {
			if(cons.getUserName().equals(psUserName) && Arrays.equals(psPassword, cons.getPassword().toCharArray())) {
				return true;
			}
		}
		return false;				
	}
	
	/**
	 * @@brief: Verify if a given password and user name of a coordinator are valid  
	 * @@pre: True
	 * @@post: The password and user name are verified
	 * @@param: psPassword
	 * @@param: psUserName  
	 * @@return: boolean
	 * @@aditional_description: none
	 */
	public boolean logInCoordinator (char[] psPassword, String psUserName)
	{
		for(CLogCoor coordinator : arlCoordinatorsLogin) {
			if(coordinator.getUserName().equals(psUserName) && Arrays.equals(psPassword, coordinator.getPassword().toCharArray())){
				manager.setSTempAcadProg(coordinator.getDepartment());
				return true;
			}
		}
		return false;			
	}
	
	/**
	 * @@brief: Given the password, user name and code of a student, this one is added   
	 * @@pre: The password, user name and code are valid.    
	 * @@post: The student is added
	 * @@param: psPassword
	 * @@param: psUserName
	 * @@param: pnCode
	 * @@aditional_description: none  
	 */
	public void addStudent(String psPassword, String psUserName, int pnCode)
	{
		arlStudentsLogin.add(new CLogStu(psPassword, psUserName, pnCode));
	}
	
	/**
	 * @@brief: Given the password and user name of a counselor, this one is added   
	 * @@pre: The password and user name are valid.    
	 * @@post: The counselor is added
	 * @@param: psPassword
	 * @@param: psUserName
	 * @@aditional_description: none  
	 */
	public void addCounselor(String psPassword, String psUserName)
	{
		arlCounselorsLogin.add(new CLogCouns(psPassword, psUserName));
	}
	
	/**
	 * @@brief: Given the password, user name and department of a coordinator, this one is added   
	 * @@pre: The password, user name and department are valid.    
	 * @@post: The coordinator is added
	 * @@param: psPassword
	 * @@param: psUserName
	 * @@param: psDepartment
	 * @@aditional_description: none  
	 */
	public void addCoordinator(String psPassword, String psUserName, String psDepartment)
	{
		arlCoordinatorsLogin.add(new CLogCoor(psPassword, psUserName, psDepartment));
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlDepartments != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeStudents ( )
	{
		int nTemp = arlStudentsLogin.size();
		String sTemp = "";
		if(nTemp == 0)
		{
			return "";
		}
		else
		{
			
			for(int i = 0; i < nTemp; i++)
			{
				sTemp += arlStudentsLogin.get(i).serialize()+"\n";//Remember: PRINT this thing, do not use println
			}
			return sTemp;
		}
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlDepartments != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeCounselors ( )
	{
		int nTemp = arlCounselorsLogin.size();
		String sTemp = "";
		if(nTemp == 0)
		{
			return "";
		}
		else
		{
			for(int i = 0; i < nTemp; i++)
			{
				sTemp += arlCounselorsLogin.get(i).serialize()+"\n";//Remember: PRINT this thing, do not use println
			}
			return sTemp;
		}
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlDepartments != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serializeCoordinators ( )
	{
		int nTemp = arlCoordinatorsLogin.size();
		String sTemp = "";
		if(nTemp == 0)
		{
			return "";
		}
		else
		{
			for(int i = 0; i < nTemp; i++)
			{
				sTemp += arlCoordinatorsLogin.get(i).serialize()+"\n";//Remember: PRINT this thing, do not use println
			}
			return sTemp;
		}
	}

	/**
	 * @param coor
	 */
	public void addCoordinator(CLogCoor coor)
	{
		arlCoordinatorsLogin.add(coor);
	}
}