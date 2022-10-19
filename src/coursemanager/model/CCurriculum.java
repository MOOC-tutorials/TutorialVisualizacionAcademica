/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CCurriculum.java 
 * @@brief    
 * @@version  1.0
 * @@date     24/03/2006
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
import java.util.LinkedList;

//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> This class contains information about curriculums  <\br>
 * @@invariant: Rules that appear in him are valid, therefore also the courses.   
 */
public class CCurriculum {
	
	/**
	 * LinkedList of courses
	 */
	private LinkedList<CCourse> lklCourses;
	
	/**
	 * LinkedList of Corequirements
	 */
	private LinkedList<CCoreq> lklCoreq;
	
	/**
	 * LinkedList of Prerequirements
	 */
	private LinkedList<CPrereq> lklPrereq;
	
	/**
	 * LinkedList of area rules
	 */
	private LinkedList<CArea> lklAreas;
	
	/**
	 * Matrix of Curriculum courses
	 */
	private CCurriculumCourse[][] curriculum;
	
	/**
	 * Class constructor
	 * @@pre: True
	 * @@pos: Creates a curriculum.
	 */
	public CCurriculum() 
	{
		lklCourses = new LinkedList<CCourse>();
		lklCoreq = new LinkedList<CCoreq>();
		lklPrereq = new LinkedList<CPrereq>();
		lklAreas = new LinkedList<CArea>();	
		curriculum = new CCurriculumCourse[10][10];		
	}
	
	/**
	 * @@brief: Adds a course to the curriculum of an academic program    
	 * @@pre: Course is a valid curse with all its arguments and it's not in the list.     
	 * @@post: The course is added
	 * @@param: pCourse  
	 */
	public void addCourse(CCourse pCourse) 
	{
		lklCourses.add(pCourse);
	}	

	/**
	 * @@brief: deletes a course to the curriculum of an academic program   
	 * @@pre: the course exist in the curriculum    
	 * @@post: the course es deleted
	 * @@param: psCode  
	 * @@aditional_description: none
	 */
	public void deleteCourse(String psCode) 
	{
		Iterator it = lklCourses.iterator();
		boolean found = false;
		CCourse tempCourse = null;
		
		while (it.hasNext() && !found)
		{
			tempCourse = (CCourse)it.next();
			if (tempCourse.getSCode().equals(psCode))
			{
				found = true;
			}			
		}
		if ( found )
		{
			lklCourses.remove(tempCourse);				
		}
				
	}
		
	/**
	 * @@brief: Gives a cuorse of the curriculum given the code   
	 * @@pre: true   
	 * @@post: if the course exist in the curriculum, the course is given
	 * @@param: psCode  
	 * @@return: CCourse
	 * @@aditional_description: none 
	 */
	public CCourse getCourse(String psCod) 
	{
		Iterator it = lklCourses.iterator();
		boolean found = false;
		CCourse tempCourse = null;
		
		while (it.hasNext() && !found)
		{
			tempCourse = (CCourse)it.next();
			if (tempCourse.getSCode().equals(psCod))
			{
				found = true;
			}			
		}
		if ( found )
		{
			return tempCourse;
		}
		else
		{
			return null;
		}		
		
	}
	
	/**
	 * @@brief: Gives a observable course of the curriculum given the code   
	 * @@pre: true   
	 * @@post: if the course exist in the curriculum, the course is given
	 * @@param: psCode  
	 * @@return: CCourse
	 * @@aditional_description: none 
	 */
	public CCurriculumCourse getCourseObservable(int pnRow, int pnColumn) 
	{
		return curriculum[pnRow][pnColumn];		
	}
	
	/**
	 * @@brief: Adds a prerrequirement rule to the curriculum  
	 * @@pre: The information in the param pRule is valid     
	 * @@post: Tthe prerrequirement rule is added
	 * @@param: pRule  
	 * @@aditional_description: none 
	 */
	public void addPrereq(CPrereq pRule) 
	{
		lklPrereq.add(pRule);		
	}
	
	/**
	 * @@brief: Adds a correquirement rule to the curriculum  
	 * @@pre: The information in the param pRule is valid     
	 * @@post: The correquirement rule is added
	 * @@param: pRule  
	 * @@aditional_description: none 
	 */
	public void addCoreq(CCoreq pRule) 
	{
		lklCoreq.add(pRule);
	}
	
	/**
	 * @@brief: Adds an area rule to the curriculum  
	 * @@pre: The information in the param pRule is valid     
	 * @@post: The area rule is added
	 * @@param: pRule  
	 * @@aditional_description: none 
	 */
	public void addAreaRule(CArea pRule) 
	{
		lklAreas.add(pRule);		
	}

	/**
	 * @@brief: Gives all curriculum courses  
	 * @@pre: The curriculum has courses     
	 * @@post: The curriculum courses are given
	 * @@param: arrSCodes
	 * @@param: arrSName  
	 * @@aditional_description: none 
	 */

	public void getAllCourses(ArrayList arrSCodes, ArrayList arrSNames) 
	{
		Iterator it = lklCourses.iterator();
		CCourse course = null;		
		while(it.hasNext())
		{
			course = (CCourse) it.next();
			arrSCodes.add(course.getSCode());
			arrSNames.add(course.getSName());
		}		
	}

	/**
	 * @@brief: Gives the prerrequirement of a course given his code  
	 * @@pre: The course exist in the curriculum    
	 * @@post: The prerrequirements of a course are given
	 * @@param: pnCodeCourse
	 * @@param: parrPrereqs
	 * @@aditional_description: none 
	 */
	public void getPrereqs(String pnCodeCourse, ArrayList parrPrereqs) 
	{
		Iterator it = lklPrereq.iterator();
		CPrereq pre;		
		while ( it.hasNext() )
		{
			pre = (CPrereq)it.next();
			if ( pre.getSCourse().equals(pnCodeCourse) )
			{
				parrPrereqs.add(pre.getSPreReq());	
			}
		}		
	}

	/**
	 * @@brief: Gives the correquirement of a course given his code  
	 * @@pre: The course exist in the curriculum    
	 * @@post: The correquirements of a course are given
	 * @@param: pnCodeCourse
	 * @@param: parrCoreqs
	 * @@aditional_description: none 
	 */
	public void getCoreqs(String pnCodeCourse, ArrayList parrCoreqs) 
	{
		Iterator<CCoreq> it = lklCoreq.iterator();
		CCoreq co;		
		while ( it.hasNext() )
		{
			co = (CCoreq)it.next();
			if ( co.getSCourse1().equals(pnCodeCourse) )
			{
				parrCoreqs.add(co.getSCourse2());							
			}
			else if ( co.getSCourse2().equals(pnCodeCourse) )
			{
				parrCoreqs.add(co.getSCourse1());			
			}
		}	
		
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: lklCourses != null, lklCoreq != null, lklPrereq != null, lklAreas != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize()
	{
		String sTemp = "";
		Iterator it = lklCourses.iterator();
		while ( it.hasNext() )
		{
			sTemp += ((CCourse)it.next()).serialize()+"\n";			
		}
		it = lklCoreq.iterator();
		
		while ( it.hasNext() )
		{
			sTemp += ((CCoreq)it.next()).serialize()+"\n";			
		}
		
		it = lklPrereq.iterator();
		while ( it.hasNext() )
		{
			sTemp += ((CPrereq)it.next()).serialize()+"\n";			
		}
		
		it = lklAreas.iterator();
		while ( it.hasNext() )
		{
			sTemp += ((CArea)it.next()).serialize()+"\n";			
		}
		sTemp += "end2";
		return sTemp;
	}

	/**
	 * @@brief: Gets a list of the different areas and the number of courses of those areas  
	 * @@pre: at less an area exist      
	 * @@post: The list of areas and number of curses are given 
	 * @@param: ArrayList arrAreas
	 * @@param: ArrayList arrNumCourses   
	 * @@return: The params by reference 
	 * @@aditional_description: none
	 */
	public void getListAreas(ArrayList<String> arrAreas, ArrayList<String> arrNumCourses) 
	{
		Iterator it = lklAreas.iterator();
		CArea area;
		String num;
		Integer i;
		while ( it.hasNext() )
		{
			area = (CArea)it.next();
			i = area.getNCoursesNumber();
			num = i.toString();
			arrAreas.add((String)area.getSName());
			arrNumCourses.add((String)num);
		}		
	}

	/**
	 * @@brief: Gets a list of the different areas names and the name of the courses that belong to those areas  
	 * @@pre: at less an area exist      
	 * @@post: The list of areas and the name of the courses that belong to those areas are given 
	 * @@param: ArrayList psNameAreas
	 * @@param: ArrayList nameCourses   
	 * @@return: The params by reference 
	 * @@aditional_description: none
	 */
	public void getAreaCourses(String psNameArea, ArrayList nameCourses) 
	{
		Iterator it = lklAreas.iterator();
		CArea area;
		boolean found = false;
		ArrayList courses;
		String temp;
		while ( it.hasNext() && !found)
		{
			area = (CArea)it.next();
			if ( area.getSName().equals(psNameArea))
			{
				courses = area.getSCourses();
				Iterator it2 = courses.iterator();
				while ( it2.hasNext())
				{
					temp = (String)it2.next();
					nameCourses.add(temp);
				}				
				found = true;				
			}			
		}				
	}
	
	/**
	 * @@brief: Deletes a course to the prerrequirement rule  
	 * @@pre: the prerrequirement rule exist       
	 * @@post: If the prerrequirement rule contain the course, this is deleted 
	 * @@param: psCourse
	 * @@return: void 
	 * @@aditional_description: none
	 */
	public void deletePreRule(String psPreC, String psCourse) 
	{
		Iterator it = lklPrereq.iterator();
		CPrereq pre;
		boolean found = false;
		while ( it.hasNext() && !found )
		{
			pre = (CPrereq)it.next();
			if (pre.getSPreReq().equals(psPreC) && pre.getSCourse().equals(psCourse))
			{
				lklPrereq.remove(pre);
				found = true;
			}
		}		
	}

	/**
	 * @@brief: Deletes a course to the correquirement rule  
	 * @@pre: the correquirement rule exist       
	 * @@post: If the correquirement rule contain the course, this is deleted 
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: void 
	 * @@aditional_description: none
	 */
	public void deleteCorRule(String psCourse1, String psCourse2) 
	{
		Iterator it = lklCoreq.iterator();
		CCoreq cor;
		boolean found = false;
		while ( it.hasNext() && !found)
		{
			cor = (CCoreq)it.next();
			if ( cor.getSCourse1().equals(psCourse1) && cor.getSCourse2().equals(psCourse2)
				     || cor.getSCourse1().equals(psCourse2) && cor.getSCourse2().equals(psCourse1))
			{
				lklCoreq.remove(cor);	
				found = true;
			}	
		}		
	}
	
	/**
	 * @@brief: Adds a course to the existent curriculum  
	 * @@pre: the curriculum and the course exist       
	 * @@post: the curse is added to the curriculum 
	 * @@param: psCode
	 * @@param: pnRow
	 * @@param: pnColumn 
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public CodRes addCourseToCurriculum(String psCode, int pnRow)
	{
		int initialSemester = pnRow;
		int nColumn, i, j;
		boolean prereq = false;
		boolean coreq = false;
		CCurriculumCourse tempCourse = null;
		String tempCode = "";
		boolean ok = true;
		ArrayList<String> ar = new ArrayList<String>();
		
		if ( curriculum[pnRow][9] != null)   //Reviso si hay cupo.
		{
			return CodRes.FULL;
		}
		
		if ( psCode.startsWith("*"))
		{	
			CCurriculumCourse addedCourse = new CCurriculumCourse(psCode);
			for ( nColumn = 0; nColumn < 10 && curriculum[pnRow][nColumn]!= null; nColumn++)
			{}   //Solo se quiere incrementar	
			curriculum[pnRow][nColumn] = addedCourse;
			return CodRes.SUCCESS;
		}
		
		//Busco si ya esta agregado.
		for ( i = 0; i < 10 && ok; i++)
		{
			for ( j = 0; j < 10 && curriculum[i][j] != null && ok; j++)
			{
				if ( curriculum[i][j].getCourseCode().equals(psCode))
				{
					ok = false;
				}
			}
		}
		if ( !ok )
		{
			return CodRes.ALREADY_EXISTS;
		}
		//Valido nivel
		if ( !validateLevel( psCode, pnRow, getCurriculum()))
		{
			return CodRes.LEVEL_ERROR;
		}
		
		//	Reviso si en los semestres posteriores no hay 
		//  un curso que sea prereq o coreq de psCode.
		//  Ej: Meto FCC antes de HDF
		i = initialSemester;
		
		for (  ; i < 10 && ok; i++)
		{
			for ( j = 0; j < 10 && curriculum[i][j] != null && ok; j++)
			{
				tempCourse = curriculum[i][j];
				tempCode = tempCourse.getCourseCode();
				if ( isPrereq(tempCode, psCode))
				{
					ok = false;
					prereq = true;
				}	
				if ( areCoreq(psCode, tempCode))
				{
					ok = false;
					coreq = true;
				}
			}			
		}
		
		//Reviso que antes no hay un curso del que se es prereq.
		// Ej: Meto HDF despues de FCC
		i = initialSemester;
		for ( i = initialSemester; i >= 0 && ok; i--)
		{
			for ( j = 0; j < 10 && curriculum[i][j] != null && ok; j++)
			{
				tempCourse = curriculum[i][j];
				tempCode = tempCourse.getCourseCode();
				if ( isPrereq(psCode, tempCode))
				{
					ok = false;
					prereq = true;
				}
			}
		}
		
		if ( !ok )
		{
			if ( prereq )
				return CodRes.PREREQ;
			else
				return CodRes.COREQ;			
		}
		//Reviso si en los semestres posteriores no hay correquisitos que involucren al curso.
		for ( i = initialSemester+1; i < 10 && ok; i++)
		{
			for ( j = 0; j < 10 && curriculum[i][j] != null && ok; j++)
			{
				tempCourse = curriculum[i][j];
				tempCode = tempCourse.getCourseCode();
				if ( areCoreq(psCode, tempCode))
				{
					ok = false;
				}							
			}			
		}
		
		if ( ok )
		{
			CCurriculumCourse addedCourse = new CCurriculumCourse(psCode);
			for ( nColumn = 0; nColumn < 10 && curriculum[pnRow][nColumn]!= null; nColumn++)
			{}   //Solo se quiere incrementar				
			getCoreqs(psCode, ar);  //en ar quedan los correquisitos.
			if ( ar.size() + nColumn > 9)
			{
				return CodRes.INVALID_MOVE_MULTIPLE_COURSES;
			}
			else
			{				
				curriculum[pnRow][nColumn] = addedCourse;
				for ( i = 0; i < ar.size(); i++)
				{
					CCurriculumCourse cor = new CCurriculumCourse(ar.get(i));
					curriculum[pnRow][nColumn+i+1] = cor;
				}
			}
			
			return CodRes.SUCCESS;
		}
		else
		{
			return CodRes.COREQ;
		}		
	}
	
	/**
	 * @@brief: Validates a current level
	 * @@pre: the curriculum exist       
	 * @@post: The level is validated 
	 * @@param: psCode
	 * @@param: pnRow
	 * @@param: matrix [][] 
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public boolean validateLevel(String psCode, int pnRow, String matrix[][]) 
	{
		String numCode = psCode.substring(5);
		String course = "";
		boolean ok = true;
		if ( numCode.startsWith("1"))  //Antes no hay de nivel 3 o 4
		{
			for ( int i = pnRow; i >= 0; i-- )
			{
				for ( int j = 0; j < 10 && matrix[i][j] != null ; j++)
				{
					if (!matrix[i][j].equals(""))
					{
						course = matrix[i][j];	
						
						if ( course.charAt(5) == '3' || course.charAt(5) == '4')
						{
							ok = false;
						}
					}
				}
			}
			
		}
		else if ( numCode.startsWith("3") || numCode.startsWith("4"))  //Despues no hay de nivel 1.
		{
			for ( int i = pnRow; i < 10; i++ )
			{
				for ( int j = 0; j < 10 && matrix[i][j] != null ; j++)
				{
					if (!matrix[i][j].equals(""))
					{
						course = matrix[i][j];
						if ( course.charAt(5) == '1' )
						{
							ok = false;
						}
					}
				}
			}
			
		}
		else
		{}
			
		return ok;
	}

	/**
	 * @@brief: Removes a course to the curriculum  
	 * @@pre: the curriculum exist       
	 * @@post: If the course is not a prerrequirement of another, this is deleted 
	 * @@param: pnRow
	 * @@param: pnColumn 
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public CodRes removeCourseCurriculum(int pnRow, int pnColumn)
	{
		int initialSemester = pnRow, k = 0;
		int coreqs [] = new int [10];
		CCurriculumCourse tempCourse = curriculum[pnRow][pnColumn];
		String codeToDelete = tempCourse.getCourseCode();
		String tempCode = "";
		boolean ok = true;
		ArrayList<String> ar = new ArrayList<String>(); 
		
		coreqs[0] = pnColumn;
		k++;
		
		//Si es de area se borra sin problema.
		if ( codeToDelete.startsWith("*"))
		{
			curriculum[pnRow][pnColumn] = null;
			moveSemester(pnRow);
			return CodRes.SUCCESS;
		}
		
		// Reviso si en los semestres posteriores el curso no es prerrequisito.
		ar = getInversePrereqs(codeToDelete);
		
		if ( ar.size() > 0)
		{
			ok = false;
		}		
		// Reviso si en el mismo semestre hay cursos correquisitos.
		for ( int j = 0; j < 10 && curriculum[pnRow][j] != null && ok; j++)
		{
			tempCourse = curriculum[pnRow][j];
			tempCode = tempCourse.getCourseCode();
			
			if (areCoreq(codeToDelete, tempCode) && !tempCode.equals(codeToDelete))
			{
				coreqs[k] = j;
				k++;
			}				
		}			
				
		if ( ok )
		{
			for ( int i = 1; i < k; i++)  //Reviso si se pueden eliminar los correqs.
			{
				ar = getInversePrereqs(curriculum[pnRow][i].getCourseCode());
				if ( ar.size() > 0)
				{
					ok = false;
				}
			}
			if ( !ok )   //Hay problemas con los correquisitos.
			{
				return CodRes.COREQ;
			}
			else
			{				
				for ( int i = 0; i < k; i++ )
				{
					curriculum[pnRow][coreqs[i]] = null;
				}
				moveSemester(pnRow);
				return CodRes.SUCCESS;				
			}
		}
		else
		{
			return CodRes.PREREQ;
		}
			
	}
	
	/**
	 * @@brief: Moves a course in the curriculum  
	 * @@pre: the curriculum and the course exist       
	 * @@post: If the course doesnt have any problem, this is deleted 
	 * @@param: pnOldRow
	 * @@param: pnOldColumn
	 * @@param: bUp
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public CodRes moveCourseCurriculum ( int pnOldRow, int pnOldColumn, boolean bUp)
	{
		boolean ok = true;
		int coreqs [] = new int [10];
		int i = pnOldRow;
		int j = 0, k = 0;
		String courseToMove = curriculum[pnOldRow][pnOldColumn].getCourseCode();
		
		if ( courseToMove.startsWith("*"))
		{
			int inc;
			if ( bUp)
				inc = -1;
			else
				inc = 1;
			
			if ( curriculum[pnOldRow+inc][9] != null )
			{
				return CodRes.INVALID_MOVE;
			}
			else
			{
				int p = 0;
				for ( ; curriculum[pnOldRow+inc][p]!= null; p++)
				{ //Solo se quiere incrementar.	
				}
				curriculum[pnOldRow+inc][p] = curriculum[pnOldRow][pnOldColumn];
				curriculum[pnOldRow][pnOldColumn] = null;
				moveSemester(pnOldRow);
				return CodRes.SUCCESS;				
			}
		}
		
		if ( canMove(pnOldRow, pnOldColumn, bUp))   //Se revisa si se puede mover el curso.
		{			
			String tempCourse = "";
						
			coreqs[k] = pnOldColumn;  //Se agrega la columna en el arreglo de movimientos validos.
			k++;
				
			while ( j < 10 && curriculum[i][j] != null && ok )
			{
				tempCourse = curriculum[i][j].getCourseCode();
				//Se mira que no se tenga en cuenta de nuevo el curso 'inicial'. 
				//se revisa si el curso tiene correquisitos en el semestre.
				if ( !tempCourse.equals(courseToMove) && areCoreq(tempCourse, courseToMove))
				{
					if ( !canMove(i, j, bUp))   //Si no se puede mover el correquisito... no se mueve nada.
					{
						ok = false;
					}
					else
					{						//Se agrega el indice.
						coreqs[k] = j;	
						k++;
					}
				}				
				
				j++;
				if ( j == pnOldColumn)
				{
					j++;
				}				
			}			
		}
		else
		{
			return CodRes.INVALID_MOVE;
		}
		
		if ( ok )
		{
			int pos;
			CCurriculumCourse temp = null;
			int coursesNextSemester = 0;
			int incr;
			
			if ( bUp)
			{
				incr = -1;
			}
			else
			{
				incr = 1;
			}
			
			for ( ; curriculum[i+incr][coursesNextSemester]!= null; coursesNextSemester++)
			{ //Solo se quiere incrementar.	
			}
			
			if ( (10-coursesNextSemester) < k )  //Reviso si hay cupo para meter los cursos.
			{
				ok = false;
				return CodRes.FULL;
			}
			else
			{
				for ( int t = 0; t < k; t++)
				{
					pos = coreqs[t];
					temp = curriculum[i][pos];
					curriculum[i][pos] = null;	
					curriculum[i+incr][coursesNextSemester] = temp;
					coursesNextSemester++;
				}				
			}
			moveSemester(i);
			return CodRes.SUCCESS;
		}
		else
		{
			return CodRes.COREQ;
		}
	}	

	/**
	 * @@brief: Checks if a course can be moved in the curriculum  
	 * @@pre: The curriculum and the course exist       
	 * @@post: You know if the course can be moved or not 
	 * @@param: pnRow
	 * @@param: pnColumn
	 * @@param: bUp
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	private boolean canMove ( int pnRow, int pnColumn, boolean bUp)
	{
		int j, i = 0;
		boolean ok = true;
		String tempCode = ""; 
		String course = curriculum[pnRow][pnColumn].getCourseCode();
		
		if ( !bUp )  //para abajo
		{			
			if ( pnRow == 9)
			{
				ok = false;
			}
			else
			{
				j = pnRow+1; 	
				if ( curriculum[j][9] != null )   //Semestre anterior lleno.
				{
					ok = false;
				}				
				while ( i < 10 && curriculum[j][i] != null && ok)
				{
					tempCode = curriculum[j][i].getCourseCode();
					if ( isPrereq(course, tempCode) && !tempCode.equals(course))
					{
						ok = false;
					}
					i++;			
				}
				if ( i == 10 )
				{
					ok = false;
				}
			}
		}
		else  //Para arriba
		{
			if ( pnRow == 0)
			{
				ok = false;
			}			
			else
			{
				j = pnRow - 1;
				if ( curriculum[j][9] != null )   //Semestre anterior lleno.
				{
					ok = false;
				}
				while ( i < 10 && curriculum[j][i] != null && ok)
				{
					tempCode = curriculum[j][i].getCourseCode();
					if ( isPrereq(tempCode, course) && !tempCode.equals(course))
					{
						ok = false;
					}
					i++;				
				}				
			}		
		}
		return ok;
		
	}
	
	/**
	 * @@brief: Checks if a course is prerrequirement of another  
	 * @@pre: The courses exist       
	 * @@post: You know if a course is prerrequirement of another 
	 * @@param: psCoursePre
	 * @@param: psCourse
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public boolean isPrereq ( String psCoursePre, String psCourse)
	{
		Iterator<CPrereq> it = lklPrereq.iterator();
		CPrereq temp;
		boolean found = false;
		
		while ( it.hasNext() && !found)
		{
			temp = it.next();
			if ( psCoursePre.equals(temp.getSPreReq()) && psCourse.equals(temp.getSCourse()))
			{
				found = true;
			}			
		}
		return found;
	}
	
	/**
	 * @@brief: Checks if two courses are correquirement between them  
	 * @@pre: The courses exist       
	 * @@post: You know if the two courses are correquirement between them 
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: boolean 
	 * @@aditional_description: none
	 */
	public boolean areCoreq ( String psCourse1, String psCourse2 )
	{
		Iterator<CCoreq> it = lklCoreq.iterator();
		CCoreq temp = null;
		String c1 ="", c2 = ""; 
		boolean found = false;
		
		while ( it.hasNext() && !found)
		{
			temp = it.next();
			c1 = temp.getSCourse1();
			c2 = temp.getSCourse2();
			if ( (psCourse1.equals(c1) || psCourse1.equals(c2)) &&
					(psCourse2.equals(c1) || psCourse2.equals(c2)))
			{
				found = true;
			}			
		}
		return found;
	}

	/**
	 * @@brief: Gives the actual curriculum  
	 * @@pre: The curriculum exist       
	 * @@post: The curriculum is given 
	 * @@param: none
	 * @@return: String [][] (Contain the courses of the curriculum) 
	 * @@aditional_description: none
	 */
	public String[][] getCurriculum() 
	{
		String courseCode = "";
		String[][] curr = new String [10][10];
		for ( int i = 0; i < 10; i++ )
		{
			for ( int j = 0; j < 10; j++ )
			{
				if ( curriculum[i][j] != null )
				{					
					courseCode = curriculum[i][j].getCourseCode();					
				}
				else
				{
					courseCode = "";					
				}
				curr[i][j] = courseCode;
			}
		}
		return curr;
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
			if ( curriculum[pnSemester][i] == null )
			{
				for ( j = i+1; j < 9 && curriculum[pnSemester][j] == null ; j++)
				{}
				curriculum[pnSemester][i] = curriculum[pnSemester][j];
				curriculum[pnSemester][j] = null;
			}
		}		
	}
	
	/**
	 * @@brief: Gives the inverse correquirement of a given course
	 * @@pre: The course exist     
	 * @@post: The inverse correquirement of a course is given 
	 * @@param: psCourseCode
	 * @@return: ArrayList<String>
	 * @@aditional_description: none
	 */
	private ArrayList<String> getInversePrereqs(String psCourseCode)
	{
		ArrayList<String> ar = new ArrayList<String>();
		String temp = "";
		for ( int i = 0; i < 10; i++ )
		{
			for ( int j = 0; j < 10 && curriculum[i][j]!= null; j++)
			{				
				temp = curriculum[i][j].getCourseCode();
				if ( isPrereq(psCourseCode, temp))
				{
					ar.add(temp);
				}
			}
		}
		return ar;
	}

	public void cleanObserver() 
	{	
		for ( int i = 0; i < 10; i++ )
		{
			for ( int j = 0; j < 10 && curriculum[i][j]!= null; j++)
			{
				curriculum[i][j].cleanObservers();				
			}
		}		
	}
}