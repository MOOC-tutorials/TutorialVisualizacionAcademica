/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CVirtualFolder.java 
 * @@brief    This file contains the definition of the CVirtualFolder class
 * @@version  1.0
 * @@date     28/03/2006
 * @@author   CriolloSoft      
 *                      
 * @@todo     Everything
 * @@bug      None for now (28/03)
 * @@comment  In the first cycle, we are going to implement just the courses already seen by the student.
 *           Everything else will be implemented in the second cycle.  
 */

//--------- Present package declaration
package coursemanager.model;

//--------- Standard Libraries import
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//--------- Own libraries import 

// -------- Class declaration and documentation
/**<br> Represents a Virtual Folder. <\br>     
 * @@invariant: An instance of this class belongs to one, and only one student.
 */

public class CVirtualFolder 
{
	/**
	 * Matrix with the related student planned courses
	 */			
	private String [][] sPlannedCourses;
	
	/**
	 * ArrayList with the courses already seen
	 */			
	private ArrayList<String> arlsCoursesAlreadySeen;
				
	/**
	 * Matrix with the disciplinary faults of the related student
	 */
	private ArrayList<CMessage> arlDisciplinaryFaults;
				
	/**
	 * Matrix with Messages for the student from the coordinator 
	 */
	private ArrayList<CMessage> alMessages;	
	
	/**
	 * Curriculum of the student.
	 */
	private CCurriculum theCurriculum;
				
	/**
	 * Class Constructor
	 * @@pre: True
	 * @@pos: A VirtualFolder with all the atributes set to null (except arlsCoursesAlreadySeen) is created
	 */			
	public CVirtualFolder ( CCurriculum curr) 
	{
		arlsCoursesAlreadySeen = new ArrayList<String>();
		sPlannedCourses = new String[13][10];		
		alMessages = new ArrayList<CMessage>();		
		arlDisciplinaryFaults = new ArrayList<CMessage>();
		theCurriculum = curr;
	}
								
	/**
	 * @@brief: Retrieves the courses already seen by the student  
	 * @@pre: True (Even if the student has not seen any course, the list will exists)     
	 * @@post: An ArrayList containing the courses already seen by the students is returned
	 * @@param: None  
	 * @@return: ArrayList<String> A String arraylist with the courses saw by the student
	 * @@aditional_description: The following is the format used in the list to store the courses
	 * 		Each row contains: #Semester_AcademicProgram(short)_Code_Name_#Credits_Grade
	  */
	 
	public ArrayList<String> getCoursesAlreadySeen ( ) 
	{
		return arlsCoursesAlreadySeen;
	}
	
	/**
	 * @@brief: Add a course to the student's courses already seen list.
	 * @@pre: True (Even if the student has not seen any course, the list will exists). Parameters are consistent with the world.      
	 * @@post: Course added.
	 * @@param: pnSemester The semester in which the course was seen.
	 * @@param: psShortAcaPro The name of the academic program (short one).
	 * @@param: pnCode The code of the course.
	 * @@param: psName The name of the course.
	 * @@param: pfNumCred Course's number of credits.
	 * @@param: pfGrade Student's Grade in this course.  
	 * @@return: void
	 * @@aditional_description: The following is the format used in the list to store the courses
	 * 		Each row contains: #Semester_AcademicProgram(short)_Code_Name_#Credits_Grade
	 */
	public void addCourseAlreadySeen (int pnSemester, String sCourseCode, String psName, float pfNumCred, float pfGrade)
	{
		int i;
		boolean end = false;
		
		for ( i = 0; i < 10 && !end; i++ )
		{
			if ( sPlannedCourses[pnSemester][i].equals(""))
			{
				end = true;
			}
		}
		
		String newCourse = "1_" + sCourseCode + "_" + psName + "_" + pfNumCred + "_" + pfGrade;
		sPlannedCourses[pnSemester][i] = newCourse;
		
		/*Integer noCode, noSemester;
		Float foNCred, foGrade;
		noCode = new Integer(pnCode);
		noSemester = new Integer(pnSemester);
		foNCred = new Float(pfNumCred);
		foGrade = new Float(pfGrade);
		String sNewCourse = new String(noSemester.toString()+"_"+psShortAcaPro+"_"+noCode.toString()+"_"+
				                       psName+"_"+foNCred.toString()+"_"+foGrade.toString());
		arlsCoursesAlreadySeen.add(sNewCourse);
		sNewCourse=null;
		foGrade=null;
		foNCred=null;
		noSemester=null;
		noCode=null;*/
	}
	
	/**
     * @@brief: Retrieves all the courses that the student have seen in the specified semester.
     * 		   The Return is a matrix composed of strings, where each row contains the information of a Course, in the following format:
     *         CourseCode  Name  #Credits  Grade
     * @@pre: The student has seen that semester    
     * @@post: A string's matrix is returned, containing all the student's specified semester information
     * @@param: pnSemester the semester that you want to get information about  
     * @@return: String[][] Contains the courses already seen in the specified semester. null if the semester does not exists or have not been seen. 
	* @@TODO: Format the output to match the contents of the GUI.This is the Format:
	                    String [][] where the first CourseCode  Name  #Credits  Grade. This method receives an int with the specified semester
	*/
	public String[][] getCoursesAlreadySeenSemester (int pnSemester)
	{
		int nCont = 0;
		ArrayList<Integer> arlnIndexes = new ArrayList<Integer>();
		Integer onSemester = new Integer(pnSemester);
		String sTemp = onSemester.toString();
		boolean bIsTwo;
		if(sTemp.length() == 1)
		{
			bIsTwo = false;
		}
		else
		{
			bIsTwo = true;
		}
		
		for(int i = 0; i < arlsCoursesAlreadySeen.size(); i++)
		{
			if(bIsTwo)
			{
				if((arlsCoursesAlreadySeen.get(i)).charAt(0) == sTemp.charAt(0) && (arlsCoursesAlreadySeen.get(i)).charAt(1) == sTemp.charAt(1))
				{
					nCont++;
					arlnIndexes.add(i);
				}
			}
			else
			{
				if((arlsCoursesAlreadySeen.get(i)). charAt(0) == sTemp.charAt(0))
				{
					nCont++;
					arlnIndexes.add(i);
				}
			}
		}
		if(nCont > 0)
		{
			String [][] sRes = new String[4][nCont];//4*Number of courses seen on that semester
			int j = 0;
			for(int i = 0; i < arlsCoursesAlreadySeen.size() && j < arlnIndexes.size(); i++)
			{
				if(i == arlnIndexes.get(j).intValue())
				{
					
					String sT = arlsCoursesAlreadySeen.get(i);
					String sVar;					
					Scanner stringScan = new Scanner(sT);
					stringScan.useDelimiter("_");//Does it works? Yes, it does
					sVar = stringScan.next();//Semester
					sVar = stringScan.next();//AcademicProgram
					sVar += "-"+stringScan.next();//AcademicProgram + NumberCode
					sRes[0][j] = sVar;
					sVar = stringScan.next();//Course's name
					sRes[1][j] = sVar;
					sVar = stringScan.next();//#Credits
					sRes[2][j] = sVar;
					sVar = stringScan.next();//Grade
					sRes[3][j] = sVar;
					j++;					
				}				
			}
			return sRes;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @@brief: Gives the actual curriculum 
	 * @@pre: The curriculum exists       
	 * @@post: The curriculum is given 
	 * @@param: none
	 * @@return: String [][] (Contain the courses of the curriculum) 
	 */
	public String[][] getCurriculum()
	{ 
		return theCurriculum.getCurriculum();
	}
	
	/**
	 * @@brief: Changes a course of semester  
	 * @@pre: The course exist       
	 * @@post: If is possible the semester of the course is changed.
	 * 		 Indicates true or false in each case 
	 * @@param: psCourse
	 * @@param: pnNewSemester
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public CodRes changeSemesterOfACourse(int pnSemester, int pnColumn, boolean bUp)
	{
		CodRes res = CodRes.SUCCESS;
		ArrayList<String> coreqs = new ArrayList<String>();
		String course = sPlannedCourses[pnSemester][pnColumn], temp = "";
		
		/*Reviso que este en un semestre no visto.*/
		if ( course.startsWith("1"))  //Curso ya visto.
		{
			return CodRes.INVALID_SEMESTER;
		}	
		/**/
		res =  verifyMove( course, pnSemester, bUp);
		if ( res == CodRes.SUCCESS )
		{
			theCurriculum.getCoreqs(course, coreqs);
			int inc;
			if ( bUp)
			{
				inc = -1;			
			}
			else
			{
				inc = 1;
			}
			int totalCourses = 0, i = 0, k = 0;
			int positions[] = new int [coreqs.size()];
			for ( i = 0; i < 10 ; i++)
			{
				temp = sPlannedCourses[pnSemester][i];
				if ( coreqs.contains(temp) )
				{
					positions[k] = i;
					k++;
				}
				if ( sPlannedCourses[pnSemester+inc][i] != null)
				{
					totalCourses++;
				}
			}			
			sPlannedCourses[pnSemester+inc][totalCourses] = course;
			sPlannedCourses[pnSemester][pnColumn] = null;
			totalCourses++;
			Iterator<String> it = coreqs.iterator();
			while ( it.hasNext())  //Meter en sig semestre.
			{
				temp = it.next();
				sPlannedCourses[pnSemester+inc][totalCourses] = temp;
				totalCourses++;
			}
			for ( i = 0; i < k; i++)   //Borrar.
			{
				sPlannedCourses[pnSemester][positions[i]] = null;
			}
			moveSemester(pnSemester);
		}		
		return res;		
	}
	
	/**
	 * @@brief: Checks if a course can be moved in the curriculum  
	 * @@pre: The curriculum and the course exist       
	 * @@post: You know if the course can be moved or not 
	 * @@param: psCode
	 * @@param: pnSemester
	 * @@return: CodRes
	 * @@aditional_description: none
	 */
	private CodRes verifyMove (String psCode, int pnSemester, boolean bUp)
	{		
		String course = "", temp = "";
		int totalCoursesNext = 0;
		boolean ok = true;
		ArrayList<String> listCourses = new ArrayList<String>();
		theCurriculum.getCoreqs(psCode, listCourses);
		listCourses.add(psCode);
		
		if ( bUp)
		{
			if ( pnSemester == 0)
			{
				return CodRes.INVALID_MOVE;
			}
			//Reviso si no tengo mi prereq inmediatamente atras.
			//Lo mismo con mis correqs.
			Iterator<String> it = listCourses.iterator();
			
			while ( it.hasNext())
			{
				course = it.next();
				for ( int i = 0; i < 10 && ok && sPlannedCourses[pnSemester-1][i] != null; i++)
				{
					temp = sPlannedCourses[pnSemester-1][i];
					if ( theCurriculum.isPrereq(temp, course) )
					{
						ok = false;
					}
					totalCoursesNext++;
				}
			}

			if ( (totalCoursesNext + listCourses.size()) > 10)
			{
				return CodRes.FULL;
			}
			if ( !ok )
			{
				return CodRes.PREREQ;
			}
			else
			{
				return CodRes.SUCCESS;
			}
		}
		else  //Es para abajo
		{
			if ( pnSemester == 9)
			{
				return CodRes.INVALID_MOVE;
			}
			//Reviso si no soy prereq de alguien que este abajo.
			//Lo mismo con mis correqs.
			Iterator<String> it = listCourses.iterator();
			while ( it.hasNext())
			{
				course = it.next();
				for ( int i = 0; i < 10 && ok && sPlannedCourses[pnSemester+1][i] != null; i++)
				{
					temp = sPlannedCourses[pnSemester+1][i];
					if ( theCurriculum.isPrereq(course, temp) )
					{
						ok = false;
					}
					totalCoursesNext++;
				}
				
			}
			if ( (totalCoursesNext + listCourses.size()) > 10)
			{
				return CodRes.FULL;
			}
			if ( !ok )
			{
				return CodRes.PREREQ;
			}
			else
			{				
				return CodRes.SUCCESS;
			}			
		}		
	
	}
	
	/**
     * @@brief: Adds a course to see   
     * @@pre: The course exist    
     * @@post: If is possible the course is added
     * @@param: psCode
     * @@param: sName
     * @@param: pfCred 
     * @@param: pnSemester
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public CodRes addCourseToSee ( String psCode, String psName, float pfCred, int pnSemester)
	{
		boolean correctSemester = true, already = false;
		String course = "";
		CodRes resB, resF;
		ArrayList<String> coreqs = new ArrayList<String>();
		//Reviso que este en un semestre no visto.
		for ( int i = 0; i < 10; i++)
		{
			course = sPlannedCourses[pnSemester][i];
			if ( course != null)
			{
				if ( course.startsWith("1"))  //Curso ya visto.
				{
					correctSemester = false;
				}
			}
			for ( int j = 0; j < 10 && sPlannedCourses[i][j] != null && !already; j++)
			{
				if ( sPlannedCourses[i][j].equals(psCode))
				{
					already = true;
				}
			}
		}
		if ( !correctSemester )
		{
			return CodRes.INVALID_SEMESTER;
		}
		if ( already)
		{
			return CodRes.ALREADY_EXISTS;
		}
		if ( !theCurriculum.validateLevel(psCode, pnSemester, sPlannedCourses ))
		{
			return CodRes.LEVEL_ERROR;
		}
		
		else
		{
			resB = checkBehind( psCode, pnSemester);
			resF = checkForward( psCode, pnSemester );
			if ( resB == CodRes.SUCCESS && resF == CodRes.SUCCESS)
			{
				theCurriculum.getCoreqs(psCode, coreqs);
				if ( coreqs.size() > 0 )
				{
					Iterator<String> it = coreqs.iterator();
					while ( it.hasNext() )
					{
						course = it.next();
						if ( checkBehind(course, pnSemester) != CodRes.SUCCESS 
							|| checkForward(course, pnSemester) != CodRes.SUCCESS)
						{
							return CodRes.COREQ;
						}
					}
				}
			}
			else
			{
				if ( resB == CodRes.SUCCESS)
					return resF;
				else
					return resB;
			}
			int count = 0;
			for ( ; count < 10 && sPlannedCourses[pnSemester][count] != null; count++)
			{} //Solo se incrementa.
			if ( !(count + coreqs.size() < 10) )
			{
				return CodRes.INVALID_MOVE_MULTIPLE_COURSES;
			}
			else
			{
				sPlannedCourses[pnSemester][count] = psCode;
				for ( int i = 0; i < coreqs.size(); i++)
				{
					sPlannedCourses[pnSemester][count+i+1] = coreqs.get(i);
				}
				return CodRes.SUCCESS;				
			}			
		}
		
	}
	
	/**
     * @@brief: Checks that a course dont have forward him prerrequirents or correquirements   
     * @@pre: The course exist    
     * @@post: A course is checked to dont have forward him prerrequirents or correquirements
     * @@param: psCode
     * @@param: pnSemester
     * @@return: CodRes
     * @@aditional_description: None 
     */
	private CodRes checkForward(String psCode, int pnSemester) 
	{
		//Adelante no existe un curso el cual psCode tiene como prereq o coreq.
		//Si psCode es FCC...delante no puede estar HDF
		String courseFwd = "";
		boolean prereq = false;
		boolean ok = true;
		
		for ( int i = pnSemester; i < 10 && ok; i++)
		{
			for ( int j = 0; j < 10 && ok && sPlannedCourses[i][j]!= null; j++)
			{
				courseFwd = sPlannedCourses[i][j];
				
				if ( !courseFwd.equals(psCode))
				{
					
					if ( theCurriculum.isPrereq(courseFwd, psCode))
					{						
						ok = false;
						prereq = true;					
					}
					else if (theCurriculum.areCoreq(psCode, courseFwd) )
					{
						ok = false;					
					}
				}
			}
		}
		
		if ( ok )
		{
			return CodRes.SUCCESS;
		}
		else
		{
			if ( prereq )
			{
				return CodRes.PREREQ;
			}
			else
			{
				return CodRes.COREQ;
			}
		}
				
	}

	/**
     * @@brief: Checks that a course dont have behind him prerrequirents or correquirements   
     * @@pre: The course exist    
     * @@post: A course is checked to dont have behind him prerrequirents or correquirements
     * @@param: psCode
     * @@param: pnSemester
     * @@return: CodRes
     * @@aditional_description: None 
     */
	private CodRes checkBehind(String psCode, int pnSemester) 
	{
		//Atras no existe un curso del cual psCode es prereq o coreq.
		//Si psCode es HDF...atras no puede estar FCC
		String courseBehind = "";
		boolean prereq = false;
		boolean ok = true;
		boolean finish = false;
		
		for ( int i = pnSemester; i >= 0 && ok && !finish; i--)
		{
			for ( int j = 0; j < 10 && ok && !finish&& sPlannedCourses[i][j]!= null; j++)
			{
				courseBehind = sPlannedCourses[i][j];
				if ( courseBehind.startsWith("1"))
				{
					finish = true;
				}				
				if ( !courseBehind.equals(psCode))
				{					
					if ( theCurriculum.isPrereq(psCode, courseBehind))
					{						
						ok = false;
						prereq = true;					
					}
					else if (theCurriculum.areCoreq(psCode, courseBehind) )
					{
						ok = false;						
					}
				}
			}
		}
		if ( ok )
		{
			return CodRes.SUCCESS;
		}
		else
		{
			if ( prereq )
			{
				return CodRes.PREREQ;
			}
			else
			{
				return CodRes.COREQ;
			}
		}				
	}

	/**
     * @@brief: Deletes a course to see   
     * @@pre: The course exist    
     * @@post: If is possible the course is eliminated
     * @@param: psCode
     * @@param: pnSemester
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public CodRes deleteCourseToSee ( int pnSemester, int pnColumn)
	{
		//1.Reviso que delante mio no hay cursos de los que soy prereq y 2. si hay correqs los borro tambien.

		String course = "";
		ArrayList<String> coreqs = new ArrayList<String>();
		CodRes res = CodRes.SUCCESS;
		String psCode = sPlannedCourses[pnSemester][pnColumn];
		
		//Reviso que este en un semestre no visto.
		course = sPlannedCourses[pnSemester][0];
		if ( course.startsWith("1"))  //Curso ya visto.
		{
			return CodRes.INVALID_SEMESTER;
		}
		
		theCurriculum.getCoreqs(psCode, coreqs);
				
		if ( pnSemester != 9 )
		{
			//1.
			res = checkRulesForward(psCode, pnSemester);
			if ( res != CodRes.SUCCESS)
			{		
				return res;
			}			
		}
		//Si llego aca es porque no hay problemas con el curso
		//... falta revisar sus coreqs.
		if ( coreqs.size() > 0 )  //Tiene correqs.
		{
			Iterator<String> it = coreqs.iterator();
			while ( it.hasNext() && res == CodRes.SUCCESS)
			{
				course = it.next();
				res = checkRulesForward(course, pnSemester);
			}
			if ( res != CodRes.SUCCESS)
			{
				return res;
			}
			else
			{	//Borro los correqs.
				for ( int i = 0; i < 10; i++)
				{
					course = sPlannedCourses[pnSemester][i];
					if ( course != null )
					{	
						if (coreqs.contains(course))
						{
							sPlannedCourses[pnSemester][i] = null;
						}
					}
				}
			}
			
		}
		//Solo falta borrar el curso.
		sPlannedCourses[pnSemester][pnColumn] = null;
		moveSemester(pnSemester);
		return CodRes.SUCCESS;	
	
	}
	
	/**
     * @@brief: Checks the fordward rules of a given course   
     * @@pre: The course exist    
     * @@post: The fordward rules of a given course is checked
     * @@param: psCode
     * @@param: pnSemester
     * @@return: CodRes
     * @@aditional_description: None 
     */
	private CodRes checkRulesForward(String psCode, int pnSemester) 
	{
		String course = "";
		boolean prereq = false;
		boolean ok = true;
		
		for ( int i = pnSemester + 1; i < 10 && ok; i++ )
		{
			for ( int j = 0; j < 10 && ok && sPlannedCourses[i][j] != null; j++)
			{
				course = sPlannedCourses[i][j];
				if ( !course.equals(psCode))
				{						
					if ( theCurriculum.isPrereq(psCode, course))
					{
						ok = false;
						prereq = true;
					}
					if ( theCurriculum.areCoreq(psCode, course))
					{
						ok = false;						
					}
				}
			}
		}
		
		if ( ok )
			return CodRes.SUCCESS;
		else
			if ( prereq)
				return CodRes.PREREQ;
			else
				return CodRes.COREQ;
		
	}

	/**
     * @@brief: Verifies if a student ends his career   
     * @@pre: The student exist   
     * @@post: You know if a student realy finish his career
     * @@param: none
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public boolean verifyEndOfCareer ()
	{
		
		String curr[][] = getCurriculum();
		String check = "";
		boolean ok = true;
		int totalAreas = 0;
		
		for ( int i = 0; i < 10 && ok; i++)
		{
			for ( int j = 0; j < 10 && ok && curr[i][j] != ""; j++)
			{
				ok = false;
				check = curr[i][j];				
				if ( isObligatory(check))
				{
					ok = true;
				}
				/*else if ( isInSomeArea(check))
				{
					ok = true;
					totalAreas++;
				}*/				
			}			
		}
		int numAreas = getNumberAreas();
		if ( totalAreas < numAreas )
		{
			ok = false;
		}
		return ok;
	}
	
	/**
	 * Gives the total of areas to see.
	 * @@return The total courses to see from the areas.
	 */
	private int getNumberAreas() 
	{
		int total = 0;
		ArrayList<String> numCourses = new ArrayList<String>();
		ArrayList<String> a = new ArrayList<String>();
		theCurriculum.getListAreas(a, numCourses);
		Iterator<String> it = numCourses.iterator();
		String num = "";
		while ( it.hasNext() )
		{
			num = it.next();
			Integer i = new Integer(num);
			total += i;			
		}
		return total;
	}

	private boolean isInSomeArea(String psCourse) 
	{
		ArrayList<String> areas = new ArrayList<String>();
		ArrayList<String> numCourses = new ArrayList<String>();
		theCurriculum.getListAreas(areas, numCourses);
		Iterator it = areas.iterator();
		String area = "", areaCourse = "";
		boolean exists = false;
		while (it.hasNext() && !exists)
		{
			area = (String) it.next();
			ArrayList<String> courses = new ArrayList<String>();
			theCurriculum.getAreaCourses(area, courses);
			Iterator itC = courses.iterator();
			while (itC.hasNext() && !exists)
			{
				areaCourse = (String)itC.next();
				if ( areaCourse.equals(psCourse))
				{
					exists = true;
				}				
			}							
		}				
		return exists;
	}

	private boolean isObligatory(String psCourse) 
	{
		String curr[][] = sPlannedCourses;
		String temp = "";
		boolean found = false;
		for ( int i = 0; i < 10 && !found; i++)
		{
			for ( int j = 0; j < 10 && !found && curr[i][j] != null; j++)
			{
				temp = curr[i][j];
				if (temp.startsWith("1"))
				{
					temp = extractCode(temp);
				}
				if ( temp.equals(psCourse))
				{	found = true;
				}				
			}			
		}
		return found;
	}

	private String extractCode(String psCourseSeen) 
	{
		return psCourseSeen.split("_")[1];
	}

	/**
	 * @@brief: Receives an existent message  
	 * @@pre: The message exist	
	 * @@post: The message is received
	 * @@param: psForm
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@return: void 
	 */
	public void receiveMessage ( String psFrom, String psSubject, String psMessage)
	{
		CMessage message = new CMessage(psFrom, psSubject, psMessage, alMessages.size());;
		alMessages.add(message);		
	}
	
	/**
	 * @@brief: Receives a fault of a student  
	 * @@pre: True
	 * @@post: The student fault is received
	 * @@param: psForm
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@return: void 
	 */
	public void receiveFault ( String psFrom, String psSubject, String psMessage)
	{
		CMessage message = new CMessage(psFrom, psSubject, psMessage, alMessages.size());;
		arlDisciplinaryFaults.add(message);		
	}
	
	/**
	 * @@brief: Gets the body of a message  
	 * @@pre: The body of the message exist	
	 * @@post: The body of the message is received
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the body of the message) 
	 */
	/*
	 * Formato: leido (0 o 1) + /t + id + /t + from + /t + subject
	 */
	public ArrayList<String> getMessagesBody() 
	{
		ArrayList<String> body = new ArrayList<String>();
		Iterator<CMessage> it = alMessages.iterator();
		String temp = "";
		CMessage tempMessage = null;
		while ( it.hasNext())
		{			
			tempMessage = it.next();
			if ( tempMessage.isReaded())
			{
				temp = "0" + "\t";
			}
			else
			{
				temp = "1" + "\t";
			}			 
			temp += tempMessage.getId() + "\t";
			temp += tempMessage.getFrom() + "\t";
			temp +=  tempMessage.getSubject();
			body.add(temp);			
		}
		return body;
	}
	
	/**
	 * @@brief: Gets the content of a student faults  
	 * @@pre: True	
	 * @@post: The faults of a student are seen
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the student faults) 
	 */
	/*
	 * Formato: leido (0 o 1) + /t + id + /t + from + /t + subject
	 */
	public ArrayList<String> getFaultsBody() 
	{
		ArrayList<String> body = new ArrayList<String>();
		Iterator<CMessage> it = arlDisciplinaryFaults.iterator();
		String temp = "";
		CMessage tempMessage = null;
		while ( it.hasNext())
		{			
			tempMessage = it.next();
			if ( tempMessage.isReaded())
			{
				temp = "0";
			}
			else
			{
				temp = "1";
			}			 
			temp += tempMessage.getId() + "\t";
			temp += tempMessage.getFrom() + "\t";
			temp +=  tempMessage.getSubject();
			body.add(temp);			
		}
		return body;
	}
	
	/**
	 * @@brief: Gets a specific message  
	 * @@pre: The message exist	
	 * @@post: The especific message is received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificMessage( String psId )
	{
		Integer i = new Integer(psId);
		int pos = i;
		alMessages.get(pos).readMessage();
		return alMessages.get(pos).getMessage();		
	}
	
	/**
	 * @@brief: Gets the specification of a faults  
	 * @@pre: True	
	 * @@post: The especifications of a faults are received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificFault( String psId )
	{
		Integer i = new Integer(psId);
		int pos = i;
		arlDisciplinaryFaults.get(pos).readMessage();
		return arlDisciplinaryFaults.get(pos).getMessage();		
	}	
	
	/**
	 * @@brief: Gets the planned curriculum  
	 * @@pre: True	
	 * @@post: The planned curriculum is given
	 * @@param: none
	 * @@return: String [][] 
	 */
	public String[][] getPlannedCurriculum()
	{
		String courseCode = "";
		String[][] planedCurr = new String [13][10];
		for ( int i = 0; i < 13; i++ )
		{
			for ( int j = 0; j < 10; j++ )
			{
				if ( sPlannedCourses[i][j] != null )
				{					
					courseCode = sPlannedCourses[i][j];					
				}
				else
				{
					courseCode = "";					
				}
				planedCurr[i][j] = courseCode;
			}
		}
		return planedCurr;
	}
	
	/**
	 * @@brief: Deletes the spaces between smesters for move the nulls at the end
	 * @@pre: The curriculum exist       
	 * @@post: The semester is moved 
	 * @@param: pnSemester
	 * @@return: Void
	 * @@aditional_description: none
	 */
	// Quita los espacios en los semestres para que los null queden al final.
	private void moveSemester(int pnSemester) 
	{
		int i, j;
		for ( i = 0; i < 9; i++)
		{
			if ( sPlannedCourses[pnSemester][i] == null )
			{
				for ( j = i+1; j < 9 && sPlannedCourses[pnSemester][j] == null ; j++)
				{}
				sPlannedCourses[pnSemester][i] = sPlannedCourses[pnSemester][j];
				sPlannedCourses[pnSemester][j] = null;
			}
		}		
	}
	
	public StringBuilder serialize ( )
	{
		StringBuilder sbSerialize = new StringBuilder();
		//messages	
		int nSize = alMessages.size();
		if(nSize == 0)
		{
			sbSerialize.append("nomessages\n");
		}
		else
		{
			for(int i = 0; i < nSize; i++)
			{
				sbSerialize.append(alMessages.get(i).serialize());
			}	
		}		
		sbSerialize.append("end2\n");
		//Disciplinary Faults
		nSize = arlDisciplinaryFaults.size();
		if(nSize == 0)
		{
			sbSerialize.append("nomessages\n");
		}
		else
		{
			for(int i = 0; i < nSize; i++)
			{
				sbSerialize.append(arlDisciplinaryFaults.get(i).serialize());
			}	
		}		
		sbSerialize.append("end2\n");
		//Courses Already seen
		//#SemesterSeen_AcademicProgram(short)_Code_Name_#Credits_Grade
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(sPlannedCourses[i][j] != null)
				{
					sbSerialize.append(i);
					sbSerialize.append("_");
					sbSerialize.append(sPlannedCourses[i][j]);
					sbSerialize.append('\n');					
				}				
			}
		}
		sbSerialize.append("end\n");
		return sbSerialize;
	}
	
	public void deSerialize (StringBuilder psbCourses)
	{
		
	}
}