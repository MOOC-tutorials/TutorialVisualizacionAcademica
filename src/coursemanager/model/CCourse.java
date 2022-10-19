/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CCourse.java 
 * @@brief    
 * @@version  1.0
 * @@date     22-mar-2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     Change nCreditNumber for fCreditNumber!
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.model;

import coursemanager.persistence.CourseFields;

//--------- Standar Libraries import


//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> The reprsentation of a course <\br>
 * @@invariant: None of the arguments is null.
 */
public class CCourse
{
	/**
	 * Course code
	 */
	private String sCode;
	
	/**
	 * Name of the course
	 */
	private String sName;
	
	/**
	 * Number of credits of the course
	 */
	private double nCreditNumber;
	
	/**
	 * Level of the course
	 */
	private int nLevel;
	
	/**
	 * Type of the course regarding the area
	 */
	private String sType;
	
	/**
	 * Class constructor
	 */
	public CCourse ( ) 
	{
	}
	
	/**
	 * Class constructor by parameters
	 */
	public CCourse (String psName, String psCode, float pfCreditNumber, int pnLevel, String psType ) 
	{
		sName = psName;
		sCode = psCode;
		nCreditNumber = pfCreditNumber;
		nLevel = pnLevel;
		if(psType.compareTo("") != 0)
			sType = psType;
		else
			sType = "NONE";
	}

	/**
	 * @@brief: Gives the number of credits of the course
	 * @@pre: The course exist
	 * @@post: The number of credits is given
	 * @@return: nCreditNumber
	 * @@aditional_description: none  
	 */
	public double getNCreditNumber( )
	{
		return nCreditNumber;
	}
	
	/**
	 * @@brief: Changes the number of credits of the course
	 * @@pre: The new number of credits is valid
	 * @@post: The number of credits is change
	 * @@param: pnCreditNumber
	 * @@aditional_description: none  
	 */
	public void setNCreditNumber (double pnCreditNumber)
	{
		nCreditNumber = pnCreditNumber;
	}

	/**
	 * @@brief: Gives the level of the course
	 * @@pre: The course exist
	 * @@post: The level of the course is given
	 * @@return: nLevel
	 * @@aditional_description: none  
	 */
	public int getNLevel ( )
	{
		return nLevel;
	}
	
	/**
	 * @@brief: Changes the level of the course
	 * @@pre: The new level of the course is valid
	 * @@post: The level of the course is change
	 * @@param: pnLevel
	 * @@aditional_description: none  
	 */
	public void setNLevel (int pnLevel)
	{
		nLevel = pnLevel;
	}

	/**
	 * @@brief: Gives the code of the course
	 * @@pre: The course exist
	 * @@post: The code of the course is given
	 * @@return: sCode
	 * @@aditional_description: none  
	 */
	public String getSCode ( )
	{
		return sCode;
	}

	/**
	 * @@brief: Changes the code of the course
	 * @@pre: The new code of the course is valid
	 * @@post: The code of the course is change
	 * @@param: pnCode
	 * @@aditional_description: none  
	 */
	public void setSCode (String psCode)
	{
		sCode = psCode;
	}

	/**
	 * @@brief: Gives the name of the course
	 * @@pre: The course exist
	 * @@post: The name of the course is given
	 * @@return: sName
	 * @@aditional_description: none  
	 */
	public String getSName ( )
	{
		return sName;
	}

	/**
	 * @@brief: Changes the name of the course
	 * @@pre: The new name of the course is valid
	 * @@post: The name of the course is change
	 * @@param: psName
	 * @@aditional_description: none  
	 */
	public void setSName (String psName)
	{
		sName = psName;
	}

	/**
	 * @@brief: Gives the type of the course
	 * @@pre: The course exist
	 * @@post: The type of the course is given
	 * @@return: String
	 * @@aditional_description: none  
	 */
	public String getSType ( )
	{
		return sType;
	}

	/**
	 * @@brief: Changes the type of the course
	 * @@pre: The new type of the course is valid
	 * @@post: The type of the course is change
	 * @@param: psType
	 * @@aditional_description: none  
	 */
	public void setSType (String psType)
	{
		sType = psType;
	}

	/**
	 * @@brief: Changes the name, the type, the credit number and the level of the course
	 * @@pre: The course exist and the parameters are validnew type of the course is valid
	 * @@post: the name, the type, the credit number and the level of the course are change
	 * @@param: psName
	 * @@param: pnNumCredits
	 * @@param: pnLevel
	 * @@aditional_description: none  
	 */
	public void set(String psName, float pnNumCredits, int pnLevel) 
	{
		if (psName != "")
		{
			sName = psName;
		}
		if (pnNumCredits >= 1.5 && (pnNumCredits*10)%5 == 0 && pnNumCredits <= 5)
		{
			nCreditNumber = pnNumCredits;			
		}
		if (pnLevel >= 1 && pnLevel <= 4)
		{
			nLevel = pnLevel;
		}		
	}
	
	/**
	 * 
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, sNameCode != null, arlStudent != null, curriculu != null, rulesAdmin != null, sCoordinator != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize ( )
	{
		String sTemp;
		Float ofCreNum = new Float(this.nCreditNumber);
		Integer onLevel = new Integer(this.nLevel);
		sTemp = sCode + "_"+sName+"_"+ofCreNum.toString()+"_"+onLevel.toString()+"_"+sType;
		return sTemp;
	}

	/**
	 * @param string
	 * @param string2
	 */
	public void assignCourseFieldWithData(String label, String value) {
		if(label.equals(CourseFields.getFieldName(CourseFields.CODE_ID))){
			setSCode(value);
		} else if(label.equals(CourseFields.getFieldName(CourseFields.NAME))){
			setSName(value);
		}else if(label.equals(CourseFields.getFieldName(CourseFields.CREDITS))){
			setNCreditNumber(Double.parseDouble(value));
		}else if(label.equals(CourseFields.getFieldName(CourseFields.LEVEL))){
			setNLevel(Integer.parseInt(value));
		}else if(label.equals(CourseFields.getFieldName(CourseFields.TYPE))){
			setSType(value);
		}			
	}
}