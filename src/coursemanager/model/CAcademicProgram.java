/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CAcademicProgram.java 
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

//--------- Standar Libraries import
import java.util.ArrayList;
import java.util.Iterator;

import coursemanager.persistence.AcademicProgramFields;

//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant: It has a coordinator obligatorily. Single it contains enrolled 
 * 			  students to this academic program.   
 */
public class CAcademicProgram {
	
	private Integer id;
	
	/**
	 * Name of the academic program.
	 */
	private String name;
	
	/**
	 * Name of the academic program code. Ex: ISIS
	 */
	private String nameCode;
	
	/**
	 * ArrayList to save the students belonging to the academic program
	 */
	private ArrayList<CStudent> arlStudent;
	
	/**
	 * The curriculum of the academic program
	 */
	private CCurriculum curriculum;
	
	/**
	 * Conectin with the rules administrator
	 */
	private CRulesAdmin rulesAdmin;
	
	/**
	 * Name of departments cordinator
	 */
	private String sCoordinator;
	
	/**
	 * ArrayList to save the coordinator message
	 */
	private ArrayList<CMessage> arlCoordMessages;
	
	/**
	 * Class constructor
	 * @@pre: true.
	 * @@pos: Creates an academic program
	 */
	public CAcademicProgram(String psName, String psCode) 
	{
		arlStudent = new ArrayList<CStudent>();	
		curriculum = new CCurriculum();
		rulesAdmin = new CRulesAdmin();
		arlCoordMessages = new ArrayList<CMessage>();
		name = psName;
		nameCode = psCode;
	}

	/**
	 * Class Constructor
	 */
	public CAcademicProgram()
	{
		arlStudent = new ArrayList<CStudent>();
		arlCoordMessages = new ArrayList<CMessage>();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @@brief: Given a student, this one is added to the academic program   
	 * @@pre: The student is valid.    
	 * @@post: The student is added to the academic program
	 * @@param: pStudent
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public void addStudent(CStudent pStudent) 
	{
		arlStudent.add(pStudent);
	}
	
	/**
	 * @@brief: Given a course, this one is added to the curriculum of the academic 
	 * program.   
	 * @@pre: The course is valid.    
	 * @@post: The course is added to the curriculum of the academic program
	 * @@param: course
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public CodRes addCourseCurriculum(CCourse course) 
	{
		CCourse already = curriculum.getCourse(course.getSCode());
		if (already != null)  
		{
			return CodRes.ALREADY_EXISTS;
		}
		else
		{
			curriculum.addCourse(course);
			return CodRes.SUCCESS;		
		}			

	}

	
	/**
	 * @@brief: Given the code of a course, the course is deleted
	 * @@pre: String syntax corresponds to a code    
	 * @@post: The course is deeted from the curriculum 
	 * @@param: psCode
	 * @@return: CodRes
	 * @@aditional_description: none  
	 */
	public CodRes deleteCourseCurriculum(String psCode) 
	{
		curriculum.deleteCourse(psCode);
		return CodRes.SUCCESS;  
	}
	
	/**
	 * @@brief: Given a course name the method search within the curriculum of the 
	 * academic program.   
	 * @@pre: String is valid    
	 * @@post: If there is a course with the name given is retrived. returns NULL 
	 * otherwise.
	 * @@param: psName
	 * @@return: CCourse
	 * @@aditional_description: none  
	 */
	public CCourse findCourse(String psName) 
	{
		return curriculum.getCourse(psName);
	}

	/**
	 * @@brief: Adds a prerequirements for the courses given   
	 * @@pre: The courses belong to he academic programs curriculum    
	 * @@post: Rule is added
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes addPreRule(String psCourse1, String psCourse2) 
	{
		CPrereq preRule;
		if (findCourse(psCourse1) == null || findCourse (psCourse2) == null )
		{
			return CodRes.NOT_IN_CURRICULUM; 
		}
		
		preRule = rulesAdmin.addPreRule(psCourse1, psCourse2); 
		
		if ( preRule == null)
		{
			return CodRes.ALREADY_EXISTS;   //ERROR
		}
		else
		{
			curriculum.addPrereq(preRule);
			return CodRes.SUCCESS; 			
		}
		
	}
	
	/**
	 * @@brief: Adds a corequirements for the courses given   
	 * @@pre: The courses belong to he academic programs curriculum    
	 * @@post: Rule is added
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes addCorrRule(String psCourse1, String psCourse2) 
	{
		CCoreq coRule;
		
		if (findCourse(psCourse1) == null || findCourse (psCourse2) == null )
		{
			return CodRes.NOT_IN_CURRICULUM; 
		}
		
		coRule = rulesAdmin.addCorRule(psCourse1, psCourse2);
		
		if ( coRule == null)
		{
			return CodRes.ALREADY_EXISTS;   //ERROR
		}
		else
		{
			curriculum.addCoreq(coRule); 
			return CodRes.SUCCESS; 			
		}	
		
	}
	
	/**
	 * @@brief: Adds area rules for the course given   
	 * @@pre: The course belong to the academic program's curriculum    
	 * @@post: Rule is added
	 * @@param: psArea
	 * @@param: psCourse
	 * @@param: pnNumCourses
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes addAreaRule(String psArea, String psCourse, int pnNumCourses) 
	{
		CArea area = rulesAdmin.addAreaRule(psArea, psCourse, pnNumCourses);
		if (area != null)
		{
			curriculum.addAreaRule(area);
			return CodRes.NEW_RULE; 
		}
		else
		{
			return CodRes.SUCCESS; 
		}
		
	}
	
	/**
	 * @@brief: Deletes a prerequirements for the courses given   
	 * @@pre: The courses belong to the academic programs curriculum    
	 * @@post: Rule is deleted
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes deletePreRule(String psCourse1, String psCourse2) 
	{
		CodRes res = rulesAdmin.deletePreRule(psCourse1, psCourse2);
		if ( res == CodRes.SUCCESS)
		{
			curriculum.deletePreRule(psCourse1, psCourse2);
		}
		return res;
	}
	
	/**
	 * @@brief: Deletes a corequirements for the courses given   
	 * @@pre: The courses belong to the academic programs curriculum    
	 * @@post: Rule is deleted
	 * @@param: psCourse1
	 * @@param: psCourse2
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes deleteCorRule(String psCourse1, String psCourse2) 
	{
		CodRes res = rulesAdmin.deleteCorRule(psCourse1, psCourse2);
		if ( res == CodRes.SUCCESS)
		{
			curriculum.deleteCorRule(psCourse1, psCourse2);
		}
		return res;
	}
	
	/**
	 * @@brief: Deletes an area for the course given   
	 * @@pre: The course belong to the academic program's curriculum    
	 * @@post: Rule is deleted
	 * @@param: psArea
	 * @@param: psCourse
	 * @@return: CodRes 
	 * @@aditional_description: none  
	 */
	public CodRes deleteRuleArea(String psArea, String psCourse) 
	{
		return rulesAdmin.deleteAreaRule(psArea, psCourse);
	}
	
	/**
	 * @@brief: Changes coordinator of academic program   
	 * @@pre: Strign belong to a coordiator     
	 * @@post: Coordinator is changed
	 * @@param: psName
	 * @@aditional_description: none  
	 */
	public void changeCoordinator(String psName) 
	{
		sCoordinator = psName;		
	}
	
	
	/**
	 * @@brief: Changes coordinator of academic program   
	 * @@pre: Strign belong to a coordiator     
	 * @@post: Coordinator is changed
	 * @@aditional_description: none  
	 */
	public String getNameCode()
	{
		return nameCode;
	}
	
	/**
	 * @@brief: Gets the name of this academic program   
	 * @@pre: True     
	 * @@post: Academic Program's name is returned
	 * @@return: String String containing the name of the academic program
	 * @@aditional_description: none  
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @@brief: Asks the curriculum the courses in it.   
	 * @@pre: The arrays are empty.    
	 * @@post: The arrays have the respective info.
	 * @@param: arrSCodes courses' codes. 
	 * @@param: arrSNames courses' names.
	 * @@aditional_description: Parallel arrays.
	 */
	public void getCurriculumCourses(ArrayList arrSCodes, ArrayList arrSNames) 
	{
		curriculum.getAllCourses(arrSCodes, arrSNames);		
	}

	/**
	 * @@brief: Asks the curriculum the prereqs of a given course.   
	 * @@pre: The arrays is empty, pnCodeCourse is valid. 
	 * @@post: The arrays have the respective info.
	 * @@param: pnCodeCourse is the course's code.
	 * @@param: parrPrereqs is the array to load.
	 */
	public void getListPrereqs(String pnCodeCourse, ArrayList parrPrereqs) 
	{
		curriculum.getPrereqs (pnCodeCourse, parrPrereqs);		
	}

	/**
	 * @@brief: Asks the curriculum the coreqs of a given course.   
	 * @@pre: The arrays is empty, pnCodeCourse is valid. 
	 * @@post: The array has the coreqs of the course with code pnCodeCourse. 
	 * @@param: pnCodeCourse is the course's code.
	 * @@param: parrCoreqs is the array to load.
	 */
	public void getListCoreqs(String pnCodeCourse, ArrayList parrCoreqs) 
	{
		curriculum.getCoreqs (pnCodeCourse, parrCoreqs);			
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, sNameCode != null, arlStudent != null, curriculu != null, rulesAdmin != null, sCoordinator != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize()
	{
		String sTemp = name+"\n"+nameCode+"\n"+sCoordinator+"\n";
		sTemp += rulesAdmin.serialize()+"\n";
		sTemp  += curriculum.serialize();				
		return sTemp;//println? Maybe...
	}

	/**
	 * @@brief: Returns a StringBuilder with the serialization of this class, in the format defined   
	 * @@pre: sName != null, arlCoordMessaged != null       
	 * @@post: A StringBuilder containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: StringBuilder Contains the serialized object 
	 * @@aditional_description: none
	 */
	public StringBuilder serializeMessages()
	{
		StringBuilder sbSerialize = new StringBuilder();
		sbSerialize.append(nameCode);
		sbSerialize.append('\n');
		int nSize = arlCoordMessages.size();
		if(nSize == 0)
		{
			sbSerialize.append("nomessages\n");
		}
		else
		{
			for(int i = 0; i < nSize; i++)
			{
				sbSerialize.append(arlCoordMessages.get(i).serialize());
			}	
		}		
		sbSerialize.append("end2\n");
		return sbSerialize;
	}
	
	/**
	 * @@brief: Gets the list of the existent areas   
	 * @@pre: The arraylist of areas and the number of courses is empty    
	 * @@post: The arrays have the respective info.
	 * @@param: arrAreas. 
	 * @@param: arrNumCourses
	 * @@aditional_description: none.
	 */
	public void getListAreas(ArrayList arrAreas, ArrayList arrNumCourses) 
	{
		curriculum.getListAreas(arrAreas, arrNumCourses);		
	}

	/**
	 * @@brief: Gets the list of the courses who has this area rule   
	 * @@pre: The arraylist of name courses is empty    
	 * @@post: The arraylist has the respective info.
	 * @@param: psNameArea. 
	 * @@param: nameCourses
	 * @@aditional_description: none.
	 */
	public void getAreaCourses(String psNameArea, ArrayList nameCourses) 
	{
		curriculum.getAreaCourses(psNameArea, nameCourses);		
	}
	
	/**
	 * @@brief: Set the Code of the Academic Program   
	 * @@pre: The Academic Prgram exist    
	 * @@post: The code of the Academic Program is changed
	 * @@param: psNameCode   
	 * @@return: void
	 * @@aditional_description: none
	 */
	public void setNameCode (String psNameCode)
	{
		this.nameCode = psNameCode;
	}
	
	/**
	 * @@brief: Changes the name of a coordinator   
	 * @@pre: True	
	 * @@post: The coordinator's name has been change
	 * @@param: psCoordinator the new name of the coordinator   
	 * @@return: void 
	 */
	public void setCoordinatorName (String psCoordinator)
	{
		this.sCoordinator = psCoordinator;
	}
	
	/**
	 * @@brief: Adds a course to the Curriculum   
	 * @@pre: True	
	 * @@post: you can know if the course is added or not
	 * @@param: psCode
	 * @@param: pnRow
	 * @@param: pnColumn   
	 * @@return: boolean (true or false) 
	 */
	public CodRes addCourseToCurriculum(String psCode, int pnRow )
	{
		return curriculum.addCourseToCurriculum(psCode, pnRow);		
	}
	
	/**
	 * @@brief: Removes a course of the Curriculum   
	 * @@pre: True	
	 * @@post: you can know if the course is removes or not
	 * @@param: pnRow
	 * @@param: pnColumn   
	 * @@return: boolean (true or false) 
	 */
	public CodRes removeCourseCurriculum(int pnRow, int pnColumn)
	{
		return curriculum.removeCourseCurriculum(pnRow, pnColumn);		
	}
	
	/**
	 * @@brief: Moves a course of the Curriculum   
	 * @@pre: True	
	 * @@post: you can know if the course is moved or not
	 * @@param: pnOldRow
	 * @@param: pnOldColumn
	 * @@param: bUp
	 * @@return: boolean (true or false) 
	 */
	public CodRes moveCourseCurriculum ( int pnOldRow, int pnOldColumn, boolean bUp)
	{
		return curriculum.moveCourseCurriculum(pnOldRow, pnOldColumn, bUp);		
	}

	/**
	 * @@brief: Obtaina a curriculum   
	 * @@pre: The curriculum exist	
	 * @@post: The curriculum is given
	 * @@return: String [][] (Contain the courses of the curriculum)  
	 */
	public String[][] getCurriculum() 
	{
		return curriculum.getCurriculum();		
	}

	/**
	 * @@brief: Gives the coordinator of the Academic Program  
	 * @@pre: The coordinator of the Academic Program exist	
	 * @@post: The coordinator of the Academic Program is given
	 * @@param: void
	 * @@return: String (Contain the coordinator of the Academic Program)  
	 */
	public String getCoordinator() 
	{		
		return sCoordinator;
	}

	/**
	 * @@brief: Receives a send message  
	 * @@pre: True	
	 * @@post: The message is received
	 * @@param: codeStudent
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@return: void 
	 */
	public void receiveMessage(int codeStudent, String psSubject, String psMessage) 
	{
		Integer i = new Integer(codeStudent);
		String studCode = i.toString();
		CMessage message = new CMessage(studCode, psSubject, psMessage, arlCoordMessages.size());
		arlCoordMessages.add(message);
	}
	
	/**
	 * @@brief: Gets the body of a message  
	 * @@pre: The body of the message exist	
	 * @@post: The body of the message is received
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the body of the message) 
	 */
	/*
	 * Formato: read(0 or 1) + /t + id + /t + from + /t + subject
	 */
	public ArrayList<String> getMessagesBody() 
	{
		ArrayList<String> body = new ArrayList<String>();
		Iterator<CMessage> it = arlCoordMessages.iterator();
		String temp = "";
		CMessage tempMessage = null;
		while ( it.hasNext())
		{			
			tempMessage = it.next();
			if ( tempMessage.isReaded())
			{
				temp = "0"  + "\t";
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
	 * @@brief: Gets the specific message  
	 * @@pre: The message exists	
	 * @@post: The especific message is received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificMessage( String psId )
	{
		Integer i = new Integer(psId);
		int pos = i;
		arlCoordMessages.get(pos).readMessage();
		return arlCoordMessages.get(pos).getMessage();		
	}

	/**
	 * @@brief: Gets the object curriculum  
	 * @@pre: The curriculum exist	
	 * @@post: The object curriculum is given
	 * @@param: none
	 * @@return: CCurriculum 
	 */
	public CCurriculum getCurriculumObject() 
	{		
		return curriculum;
	}

	/**
	 * @param string
	 * @param string2
	 */
	public void assignAcademicProgramFieldWithData(String label, String value)
	{
		String[] vals;
		if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.ITEM_ID))) {
			setId(Integer.parseInt(value));
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.CODE))) {
			setNameCode(value);
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.COORDINATOR))) {
			setCoordinatorName(value);
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.NAME))) {
			setName(value);
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.STUDENTS))) {
			vals = value.split(",");
			addStudentsProgram(vals);
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.RULES))) {
			
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.MESSAGES))) {
			vals = value.split(",");
			addMessagesProgram(vals);
		}else if(label.equals(AcademicProgramFields.getFieldName(AcademicProgramFields.CURRICULUM))) {
			
		}
	}
	
	private void addStudentsProgram(String[] studentId) {
		for(String student : studentId) {
			
		}
	}
	
	private void addMessagesProgram(String[] messagesId) {
		for(String message : messagesId) {
			
		}
	}
}