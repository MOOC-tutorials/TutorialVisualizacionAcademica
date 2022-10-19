/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CLogEst.java 
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



/**<br> Saves the state of a Student's Login. <\br>
 * @@invariant:
 */
public class CLogStu implements Serializable
{
	
	/**
	*Student's username
	 */
	private String sUserName;
	
	/**
	*Student's password
	 */
	private String sPassword;
	
	/**
	*Student's Code
	 */
	private int nCode;
	
	/**
	 * Class constructor by parameters
	 */
	public CLogStu (String psPassword, String psUserName, int pnCode) 
	{
		this.sPassword = psPassword;
		this.sUserName = psUserName;
		this.nCode = pnCode;
	}
	
	/**
	 * @@brief: Returns the student password   
	 * @@pre: the student exist       
	 * @@post: The student password is given 
	 * @@return: String Contains the student password 
	 * @@aditional_description: none
	 */
	public String getPassword ( )
	{
		return sPassword;
	}
	
	/**
	 * @@brief: Returns the student user name   
	 * @@pre: the student exist       
	 * @@post: The student user name is given 
	 * @@return: String Contains the student user name 
	 * @@aditional_description: none
	 */
	public String getUserName ( )
	{
		return sUserName;
	}
	
	/**
	 * @@brief: Returns the student code  
	 * @@pre: the student exist       
	 * @@post: The student code is given 
	 * @@return: Int Contains the student code
	 * @@aditional_description: none
	 */
	public int getCode ( )
	{
		return nCode;
	}
	
	/**
	 * @@brief: Changes the student password   
	 * @@pre: the student password is changed      
	 * @@post: The student password is changed 
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
		Integer onCode = new Integer(nCode);
		return sUserName+"\n"+sPassword+"\n"+onCode.toString();//UserName\nPassword\nCode
	}
	
	/**
	 * @@Overrides
	 */
	public boolean equals(Object o)
	{
		CLogStu temp = (CLogStu)o;
		if((temp.getUserName()).equals(sUserName) &&(temp.getPassword()).equals(sPassword))
			return true;
		else
			return false;
	}	
}