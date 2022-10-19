/**
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CRulesAdmin.java 
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
import java.util.Iterator;

//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> The Rules Administrator <\br>
 * @@invariant: Saved rules are valid be each other.   
 */
public class CRulesAdmin {

	/**
	 * ArrayList the contains the Coreqs of an academic program. 
	 */   
	private ArrayList arlCoreq;
	
	/**
	 * ArrayList the contains the Prereqs of an academic program. 
	 */  
	private ArrayList arlPrereq;
	
	/**
	 * ArrayList the contains the Area rules of an academic program. 
	 */  
	private ArrayList arlAreaRules;
	
	/**
	 * Constructor
	 * pre: true.
	 * pos: Creates a rules administrator.
	 */ 
	public CRulesAdmin() 
	{
		arlCoreq = new ArrayList();
		arlPrereq = new ArrayList();
		arlAreaRules = new ArrayList();
	}
	
	/**
	 * @@brief: Given a CPrerreq it validates if there is any inconsistence with other rules.
	 * @@pre: pPrerreq has no NULL arguments   
	 * @@post: If there is inconsistence, returns an error CodRes. Otherwise OK.
	 * @@param: pPrerreq is the rule to add.
	 * @@return: CodRes
	 */
	public boolean verifyPreRule(CPrereq pPrerreq) 
	{
		return true;	
	}
	
	/**
	 * @@brief: Given a CCorreq it validates if there is any inconsistence with other rules.
	 * @@pre: pPrerreq has no NULL arguments   
	 * @@post: If there is inconsistence, returns an error CodRes. Otherwise OK.
	 * @@param: pCoreq is the rule to add.
	 * @@return: CodRes
	 */
	public boolean verifyCoreqRule(CCoreq pCoreq) 
	{
		return true;		
	}
	
	/**
	 * @@brief: Given an area rule it validates if there is any inconsistence with other rules.
	 * @@pre: pPrerreq has no NULL arguments   
	 * @@post: If there is inconsistence, returns an error CodRes. Otherwise OK.
	 * @@param: pArea is the rule to add.
	 * @@return: CodRes
	 */
	public boolean verifyAreaRule(CArea pArea) 
	{
		return true;		
	}
	
	/**
	 * @@brief: Creates and adds a new CPrereq into the ArrayList of CPrereqs.
	 * @@pre: The rule is valid.  
	 * @@post: The rule is created and added.
	 * @@param: psPreCourse is the course 'Pre'.
	 * @@param: psCourse is the course directly affected by the rule.
	 * @@return: CodRes
	 */
	public CPrereq addPreRule(String psPreCourse, String psCourse) 
	{
		CPrereq newRule = new CPrereq(psPreCourse, psCourse);
		CPrereq exists = searchPreRule(psPreCourse, psCourse);
		boolean valid;
		
		if (exists != null)
		{
			return null; 
		}
		else
		{
			valid = verifyPreRule(newRule);
			if (valid)
			{
				arlPrereq.add(newRule);
				return newRule; 
			}
			else
			{
				return null; 
			}
		}
				
	}
	
	/**
	 * @@brief: Creates and adds a new CCoreq into the ArrayList of CCoreqs.
	 * @@pre: The rule is valid.  
	 * @@post: The rule is created and added.
	 * @@param: psCourse1 is the course directly affected.
	 * @@param: psCourse2 is the course directly affected.
	 * @@return: CodRes
	 */
	public CCoreq addCorRule(String psCourse1, String psCourse2) 
	{
		CCoreq newRule = new CCoreq(psCourse1, psCourse2);
		CCoreq exists = searchCorRule(psCourse1, psCourse2);
		boolean valid;
		
		if (exists != null)
		{
			return null;
		}
		else
		{
			valid = verifyCoreqRule(newRule);
			if (valid)
			{
				arlCoreq.add(newRule);
				return newRule;
			}
			else
			{
				return null;
			}
			
		}
		
	}
	
	/**
	 * @@brief: Creates and adds a new CArea into the ArrayList of CArea.
	 * @@pre: true.
	 * @@post: The rule is created (if psArea doesn't exists) and - or added(otherwise).
	 * if the course is already in the area ALREADY_EXISTS is returned. 
	 * @@param: psArea is the area where the course must be added.
	 * @@param: psCourse is the course to add.
	 * @@param: course_num is the number of course of the area to see.
	 * @@return: CodRes
	 */
	public CArea addAreaRule(String psArea, String psCourse, int courses_num) 
	{
		CArea tempArea = searchAreaRule(psArea);
		if (tempArea == null)
		{
			tempArea = new CArea(psArea, courses_num, psCourse);
			arlAreaRules.add(tempArea);
			return tempArea;
		}
		else
		{
			if (!tempArea.existsCourse(psCourse))
			{
				tempArea.addRule(psCourse);
			}
			return null;			
		}		
	}
	
	/**
	 * @@brief: Deletes a CPrereq of the ArrayList of CPrereqs.
	 * @@pre: true. 
	 * @@post: The rule is deleted if it exists. Otherwise it returns error.
	 * @@param: psCourse1 is the course 'Pre'.
	 * @@param: psCourse2 is the course directly affected by the rule.
	 * @@return: CodRes
	 */
	public CodRes deletePreRule(String psCourse1, String psCourse2) 
	{
		CPrereq ruleToDelete = searchPreRule(psCourse1, psCourse2);
		if (arlPrereq.remove(ruleToDelete))
		{
			return CodRes.SUCCESS; 
		}
		else
		{
			return CodRes.ERROR; 
		}
	}
	
	/**
	 * @@brief: Deletes a CPrereq of the ArrayList of CCoreqs.
	 * @@pre: true. 
	 * @@post: The rule is deleted if it exists. Otherwise it returns error.
	 * @@param: psCourse1 is the course 'Pre'.
	 * @@param: psCourse2 is the course directly affected by the rule.
	 * @@return: CodRes
	 */
	public CodRes deleteCorRule(String psCourse1, String psCourse2) 
	{
		CCoreq ruleToDelete = searchCorRule(psCourse1, psCourse2);
		if(arlCoreq.remove(ruleToDelete))
		{
			return CodRes.SUCCESS; 
		}
		else
		{
			return CodRes.ERROR; 
		}
	}
	
	/**
	 * @@brief: Deletes a course from an Area.
	 * @@pre: true. 
	 * @@post: The rule is deleted if it exists. Otherwise it returns error.
	 * @@param: psArea is the course 'Pre'.
	 * @@param: psCourse is the course to delete.
	 * @@return: CodRes
	 */
	public CodRes deleteAreaRule(String psArea, String psCourse) 
	{
		CArea area = searchAreaRule(psArea);
		
		if(area == null)
		{
			return CodRes.ERROR;
		}
		
		if (area.existsCourse(psCourse))
		{
			area.deleteCourse(psCourse);
			return CodRes.SUCCESS; 
		}
		else
		{
			return CodRes.INEXISTENT; 
		}
	}
	
	/**
	 * @@brief: Deletes all rules that include a given course.
	 * @@pre: true. 
	 * @@post: All the rules that include psCourse were deleted. If psCourse wasn't
	 * found it returns error.	
	 * @@param: psCourse is the course.
	 * @@return: CodRes
	 */
	public CodRes deleteAllRules(String psCourse) 
	{
		Iterator it = arlPrereq.iterator();
		Iterator it2 = arlCoreq.iterator();
		Iterator it3 = arlAreaRules.iterator();
		CPrereq tempPre;
		CCoreq tempCor;
		CArea tempArea;
		
		while (it.hasNext())
		{
			tempPre = (CPrereq)it.next();
			if ( tempPre.getSPreReq().equals(psCourse))
			{
				arlPrereq.remove(tempPre);
			}			
		}
		
		while (it2.hasNext())
		{
			tempCor = (CCoreq)it2.next();
			if( tempCor.getSCourse1().equals(psCourse) || tempCor.getSCourse2().equals(psCourse) )
			{
				arlCoreq.remove(tempCor);
			}
		}
		
		while (it3.hasNext())
		{
			tempArea = (CArea)it3.next();
			if (tempArea.existsCourse(psCourse))
			{
				tempArea.deleteCourse(psCourse);
			}
		}
		return CodRes.SUCCESS;
	}
	
	/**
	 * @@brief: Searchs an CPrereq.
	 * @@pre: true. 
	 * @@post: It returns th CPrereq if it exists, otherwise it returns NULL.
	 * @@param: pPre is the rule to be found.
	 * @@return: CPrereq
	 */
	public CPrereq searchPreRule(String psPreC, String psCourse) 
	{
		CPrereq ruleToFind = null;
		Iterator it = arlPrereq.iterator();
		while (it.hasNext())
		{
			ruleToFind = (CPrereq)it.next();
			if (ruleToFind.getSPreReq().equals(psPreC) && ruleToFind.getSCourse().equals(psCourse))
			{
				return ruleToFind;
			}
		}
		return null;
		
	}
	
	/**
	 * @@brief: Searchs an CCoreq.
	 * @@pre: true. 
	 * @@post: It returns th CCoreq if it exists, otherwise it returns NULL.
	 * @@param: psCor is the rule to be found.
	 * @@return: CCoreq
	 */
	public CCoreq searchCorRule(String psCourse1, String psCourse2) 
	{
		CCoreq ruleToFind;
		Iterator it = arlCoreq.iterator();
		
		while (it.hasNext())
		{
			ruleToFind = (CCoreq)it.next();
			if ( ruleToFind.getSCourse1().equals(psCourse1) && ruleToFind.getSCourse2().equals(psCourse2)
			     || ruleToFind.getSCourse1().equals(psCourse2) && ruleToFind.getSCourse2().equals(psCourse1))
			{
				return ruleToFind;
			}			
		}
		return null;
	}
	
	/**
	 * @@brief: Searchs an CArea.
	 * @@pre: true. 
	 * @@post: It returns th CArea if it exists, otherwise it returns NULL.
	 * @@param: psArea is the area.
	 * @@return: CArea
	 */
	public CArea searchAreaRule(String psArea) 
	{
		Iterator it = arlAreaRules.iterator();
		CArea tempArea;
		while (it.hasNext())
		{
			tempArea = (CArea)it.next();
			if (tempArea.getSName().equals(psArea) )
			{
				return tempArea;
			}
		}
		return null;		
	}
	
	/** 
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: arlCoreq != null, arlPrereq != null, arlAreaRules != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize()
	{
		String sTemp = "";
		int nTam;
		nTam = arlCoreq.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CCoreq)arlCoreq.get(i)).serialize()+"\n";
		}
		
		nTam = arlPrereq.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CPrereq)arlPrereq.get(i)).serialize()+"\n";
		}
		
		nTam = arlAreaRules.size();
		for(int i = 0; i < nTam; i++)
		{
			sTemp += ((CArea)arlAreaRules.get(i)).serialize()+"\n";
		}
		sTemp += "end1";//only a file for academic program.
		return sTemp;
	}
}