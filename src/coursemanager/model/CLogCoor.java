/**
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CLogCoor.java 
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

import coursemanager.persistence.CoordinatorFields;


//--------- Own libraries import 


// -------- Class declaration and documentation



/**<br> Saves the state of a Coordinator's Login.  <\br>
 * @@invariant:   
 */
public class CLogCoor implements Serializable
{
	
	private Integer id;
	
	/**
	 * 	Attribute to save the user name of the coordinator
	 */
	private String sUserName;
	
	/**
	 * 	Attribute to save the password for the user name
	 */
	private String sPassword;
	
	/**
	 * Attribute to specify the coordinators department
	 */
	private String sDepartment;
	
	public CLogCoor() {
		
	}
	
	/**
	 * Class constructor
	 */
	public CLogCoor (String psPassword, String psUserName, String psDepartment) 
	{
		this.sPassword = psPassword;
		this.sUserName = psUserName;
		this.sDepartment = psDepartment;
	}
	
	public void assignCoordinatorFieldWithData(String label, String value) {
		if(label.equals(CoordinatorFields.getFieldName(CoordinatorFields.ITEM_ID))){
			setId(Integer.parseInt(value));
		} else if(label.equals(CoordinatorFields.getFieldName(CoordinatorFields.NAME))){
			setsUserName(value);
		}else if(label.equals(CoordinatorFields.getFieldName(CoordinatorFields.PASSWORD))){
			setPassword(value);
		}else if(label.equals(CoordinatorFields.getFieldName(CoordinatorFields.DEPARTMENT))){
			setDepartment(value);
		}		
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @@brief: Returns the coordinator password   
	 * @@pre: the coordinator exist       
	 * @@post: The coordinator password is given 
	 * @@return: String Contains the coordinator password
	 */
	public String getPassword ( )
	{
		return sPassword;
	}
	
	/**
	 * @@brief: Returns the coordinator department   
	 * @@pre: the coordinator exist       
	 * @@post: The coordinator department is given 
	 * @@return: String Contains the coordinator department
	 */
	public String getDepartment ( )
	{
		return sDepartment;
	}

	/**
	 * @@brief: Returns the coordinator user name   
	 * @@pre: the coordinator exist       
	 * @@post: The coordinator user name is given 
	 * @@return: String Contains the coordinator user name 
	 */
	public String getUserName ( )
	{
		return sUserName;
	}
	
	public void setsUserName(String sUserName)
	{
		this.sUserName = sUserName;
	}

	/**
	 * @@brief: Changes the coordinator password   
	 * @@pre: the coordinator password is changed      
	 * @@post: The coordinator password is changed 
	 * @@param: psPassword
	 */
	public void setPassword (String psPassword)
	{
		sPassword = psPassword;
	}
	
	/**
	 * @@brief: Changes the coordinator department   
	 * @@pre: the coordinator department is changed      
	 * @@post: The coordinator department is changed 
	 * @@param: psDepartment
	 */
	public void setDepartment (String psDepartment)
	{ 
		sDepartment = psDepartment;
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlDepartments != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 */
	public String serialize ( )
	{
		return sDepartment+"\n"+sUserName+"\n"+sPassword;//Department\nUserName\nPassword
	}
	
	/**
	 * @@Overrides
	 */
	public boolean equals(Object o)
	{
		CLogCoor temp = (CLogCoor)o;		
		if((temp.getUserName()).equals(this.sUserName) &&(temp.getPassword()).equals(this.sPassword))
			return true;
		else
			return false;
	}
}