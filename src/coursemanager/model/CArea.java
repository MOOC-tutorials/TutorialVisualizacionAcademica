/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CArea.java 
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
import java.util.ArrayList;

//--------- Own libraries import 


// -------- Class declaration and documentation


/**<br> A courses area <\br>
 * @@invariant:   
 */
public class CArea
{
	   /**
	    * Name of the area rule
	    */
	   private String sName;

	   /**
	    * Number of courses of the area rule
	    */
	   private int nCoursesNumber;
	   
	   /**
	    * Array of the courses' codes in the area rule
	    */
	   private ArrayList arrlCourses;
	   
	   /**
	    * Class constructor
	    * ${tags}
	    */
	   public CArea ( ) 
	   {
		   nCoursesNumber = 0;
		   arrlCourses = new ArrayList();
	   }
	   
	   /**
	    * Class constructor
	    * ${tags}
	    */
	   public  CArea (String psName, int pnCoursesNumber, String psCourse)
	   {
		   sName = psName;
		   nCoursesNumber = pnCoursesNumber;
		   arrlCourses = new ArrayList();
		   arrlCourses.add(psCourse);
	   }
	   
	   /**
		 * @@brief: Gives the Courses which are part of this area rule
		 * @@pre: The rule exist
		 * @@post: The courses are given
		 * @@return: arrlCourses
		 * @@aditional_description: none  
		 */
	   public ArrayList getSCourses( )
	   {
		   return arrlCourses;
	   }

	   /**
		 * @@brief: Gives the number of courses which are part of this area rule
		 * @@pre: The rule exist
		 * @@post: The number of courses is given
		 * @@return: nCoursesNumber
		 * @@aditional_description: none  
		 */
	   public int getNCoursesNumber( )
	   {
		   return nCoursesNumber;
	   }

	   /**
		 * @@brief: Gives the name of the area rule
		 * @@pre: The rule exist
		 * @@post: The name of the area rule is given
		 * @@return: String
		 * @@aditional_description: none  
		 */
	   public String getSName ( )
	   {
		   return sName;
	   }

	   /**
	    * @@brief: Adds a course to the area rule
	    * @@pre: The information in the params is valid
	    * @@post: The course is added to the area rule
	    * @@param: psName
	    * @@return: CodRes
	    * @@aditional_description: none  
	    */
	   public CodRes addRule (String psName) 
	   {
		   boolean exist = existsCourse(psName);
		   if(exist)
			   return CodRes.ALREADY_EXISTS;  //codres
		   else
		   {
			   arrlCourses.add(psName);
		   }	  
		   return CodRes.SUCCESS;     //codres
	   }
	   
	   /**
	    * @@brief: Deletes a course to the area rule
	    * @@pre: The information in the params is valid
	    * @@post: The course is deleted to the area rule
	    * @@param: psCourse
	    * @@return: CodRes
	    * @@aditional_description: none  
	    */
	   public CodRes deleteCourse (String psCourse)
	   {
		   boolean exist = arrlCourses.contains(psCourse);
		   if (exist)
		   {
			   arrlCourses.remove(psCourse);
			   return CodRes.SUCCESS;	//codres
		   }
		   else
			   return CodRes.INEXISTENT;	//codres
	   }
	   
	   /**
	    * @@brief: Indicates if a course exists in this area rule
	    * @@pre: The information in the params is valid
	    * @@post: Indicates if the given course exist or not
	    * @@param: psCourse
	    * @@return: boolean
	    * @@aditional_description: none  
	    */
	   public boolean existsCourse (String psCourse)
	   {
		   boolean exist = arrlCourses.contains(psCourse);
		   return exist;
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
			String sTemp;
			Integer onCourses = new Integer(nCoursesNumber);
			sTemp = "A_"+sName+"_"+onCourses.toString()+"_";
			int nTam = arrlCourses.size();
			for(int i = 0; i < nTam; i++)
			{
				sTemp += (String)arrlCourses.get(i);
				if(i != nTam-1)
				{
					sTemp +="_";
				}
			}			
			return sTemp;
		}
}