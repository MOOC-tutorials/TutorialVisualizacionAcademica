/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CLogCouns.java 
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

//--------- Standard Libraries import
import java.io.*;

//--------- Own libraries import 


// -------- Class declaration and documentation



/**<br> Saves the state of a Counselor's Login. <\br>
 *@@invariant:   
 	
 */
public class CLogCouns implements Serializable 
{
	
	/**
	 * 	Counselor's username
	 */
	private String sUserName;
	
	/**
	 * 	Counselor's password
	 */
	private String sPassword;
	
	/**
	 * Class Constructor
	 */
	public CLogCouns (String psPassword, String psUserName) 
	{
		this.sPassword = psPassword;
		this.sUserName = psUserName;
	}
	
	/**
	 * @@brief: Returns the counselor password   
	 * @@pre: the counselor exist       
	 * @@post: The counselor password is given 
	 * @@return: String Contains the counselor password 
	 * @@aditional_description: none
	 */
	public String getPassword ( )
	{
		return sPassword;
	}
	
	/**
	 * @@brief: Returns the counselor user name   
	 * @@pre: the counselor exist       
	 * @@post: The counselor user name is given 
	 * @@return: String Contains the counselor user name 
	 * @@aditional_description: none
	 */
	public String getUserName ( )
	{
		return sUserName;
	}
	
	/**
	 * @@brief: Changes the counselor password   
	 * @@pre: the counselor password is changed      
	 * @@post: The counselor password is changed 
	 * @@param: psPassword
	 * @@aditional_description: none
	 */
	public void setPassword (String psPassword)
	{
		this.sPassword = psPassword;
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
		return sUserName+"\n"+sPassword;//UserName\nPassword
	}
	
	/**
	 * @@Overrides
	 */
	public boolean equals(Object o)
	{
		CLogCouns sTemp = (CLogCouns)o;
		if((sTemp.getUserName()).equals(sUserName) &&(sTemp.getPassword()).equals(sPassword))
			return true;
		else
			return false;
	}
}