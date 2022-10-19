/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CPrereq.java 
 * @@brief    
 * @@version  1.0
 * @@date     25/03/2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration


//--------- Standar Libraries import


//--------- Own libraries import 


// -------- Class declaration and documentation

package coursemanager.model;

/**<br> A Prerequisite of a course <\br>       
 * @@invariant:
 */
public class CPrereq
{
	/**
	 * Prerequirement of the prerequirement rule
	 */
	private String sPreReq;
	
	/**
	 * Course which has a prerequirement
	 */
	private String sCourse;
	
	/**
	 * Class constructor
	 * ${tags}
	 */
	public CPrereq ( ) 
	{
	}
	
	/**
	 * Class constructor
	 * ${tags}
	 */
	public  CPrereq(String psPreReq, String psCourse)
	{
		sPreReq = psPreReq;
		sCourse = psCourse;
	}
	
	/**
	 * @@brief: Gives the Course which has a prerequirement
	 * @@pre: The course exist
	 * @@post: The course is given
	 * @@return: String
	 * @@aditional_description: none  
	 */
	public String getSCourse ( )
	{
		return sCourse;
	}

	/**
	 * @@brief: Changes the Course which has a prerequirement
	 * @@pre: The new course is valid
	 * @@post: The course is change
	 * @@param: psCourse
	 * @@aditional_description: none  
	 */
	public void setSCourse (String psCourse)
	{
		sCourse = psCourse;
	}

	/**
	 * @@brief: Gives the Course which is a prerequirement for other course
	 * @@pre: The course exist
	 * @@post: The course is given
	 * @@return: String 
	 * @@aditional_description: none  
	 */
	public String getSPreReq ( )
	{
		return sPreReq;
	}

	/**
	 * @@brief: Changes the Course which is a prerequirement for other course
	 * @@pre: The new course is valid
	 * @@post: The course is change
	 * @@param: psPreReq
	 * @@aditional_description: none  
	 */
	public void setSPreReq (String psPreReq)
	{
		sPreReq = psPreReq;
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
		return "P_"+sPreReq+"_"+sCourse;
	}
}