/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CCoreq.java 
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
package coursemanager.model;

//--------- Standar Libraries import


//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> A Corequisite for a course <\br>
 * @@invariant: true  	
 */
public class CCoreq
{
       /**
	    * Course 1 of the corequirement rule
	    */
	   private String sCourse1;
	   
	   /**
	    * Course 2 of the corequirement rule
	    */
	   private String sCourse2;

	   /**
	    * Class constructor
	    * ${tags}
	    */   
	   public CCoreq ( ) 
	   {
	   }
	   
	   /**
	    * Class constructor
	    * ${tags}
	    */
	   public  CCoreq(String psCoreq, String psCourse)
	   {
		   sCourse1 = psCoreq;
		   sCourse2 = psCourse;
	   }

	   /**
		 * @@brief: Gives the Course which has a corequirement
		 * @@pre: The course exist
		 * @@post: The course is given
		 * @@return: sCourse
		 * @@aditional_description: none  
		 */
	   public String getSCourse1 ( )
	   {
		   return sCourse1;
	   }

	   /**
		 * @@brief: Changes the Course which has a corequirement
		 * @@pre: The new course is valid
		 * @@post: The course is change
		 * @@param: psCourse
		 * @@aditional_description: none  
		 */
	   public void setSCourse1 (String psCourse1)
	   {
		   sCourse1 = psCourse1;
	   }

	   /**
		 * @@brief: Gives the Course which has a corequirement
		 * @@pre: The course exist
		 * @@post: The course is given
		 * @@return: sCourse
		 * @@aditional_description: none  
		 */
	   public String getSCourse2 ( )
	   {
		   return sCourse2;
	   }

	   /**
		 * @@brief: Changes the Course which has a corequirement
		 * @@pre: The new course is valid
		 * @@post: The course is change
		 * @@param: psCourse2
		 * @@aditional_description: none  
		 */
	   public void setSCourse2 (String psCourse2)
	   {
		   sCourse2 = psCourse2;
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
			return "C_"+sCourse1+"_"+sCourse2;
		}
}