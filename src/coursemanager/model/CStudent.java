/**
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CStudent.java 
 * @@brief    
 * @@version  1.0
 * @@date     25/03/2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     for next cycle: Cumulative average * semester 
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.model;

import java.util.ArrayList;
import java.util.Iterator;

//--------- Standar Libraries import

//--------- Own libraries import 

// -------- Class declaration and documentation
/**<br> Represents a student with non-null arguments <\br>
 * @@invariant: The student's personal data is non-null.  
 * 			   He has a Virtual Folder 
 */
public class CStudent {
  
	/**
     * Students name
     */
    private String sName;
        
    /**
     * Students lastname
     */
    private String sLastName;
    
    /**
     * student e-mail address 
     */
    private String sEmail;
    
    /**
     * Students identification type
     */
    private String sTypeID;
    
    /**
     * Students identificarion number
     */
    private String sID;
    
    /**
     * Students id code
     */
    private int nCode;
    
    /**
     * students telephone number
     */
    private String sTelNum;
    
    /**
     * students home address
     */
    private String sAddress;
    
    /**
     * Students responsible parent name
     */
    private String sResponsibleName;
    
    /**
     * Students responsible telephone number
     */
    private String sResponsibleTel;
    
    /**
     *  Students semester
     */
    private int nSemester;
    
    /**
     *	Students major 
     */
    private String sMajor;
    
    /**
     * students comulative average grade
     */
    private float fCumulativeAverage;
    
    /**
     * students average grade for each semester
     */
    private float[] fSemestralAverage;
    
    //TODO: Add to main diagram
    
    /**
     * Student's username
     */
    //private String sUserName;
    
    /**
     * Student's virtual folder
     */
    private CVirtualFolder vrfMyFolder;
    
    
    /**
     * Constructor with arguments
     * @@pre: Arguments are valid. 
     * @@pos: A new student is created with its attributes initialized with the received values
     * @@param: psName Student's new name
     * @@param: psLastName Student's new last name
     * @@param: psEmail Student's new e-mail address
     * @@param: pnCode Student's new Code
     * @@param: psTypeID Student's new ID type
     * @@param: psID Student's new ID
     * @@param: psAddress Student's new Address     
     * @@param: psTelNum Student's new telephone number
     * @@param: psResponsibleName Student's new Responsible person name
     * @@param: psResponsibleTel Student's new Responsible person telephone number
     * @@param: pnSemester Student's initial Semester
     * @@param: pfCumulativeAverage Student's new Cumulative average
     * @@param: pfSemestralAverage Student's new Semestral average
     * @@param: psMajor Student's new Major
     */
    public CStudent(String psName, String psLastName, int pnCode, String psEmail, 
    		String psTypeID, String psID, String psAddr, String psTelNum, 
    		String psResponsibleName, String psResponsibleTel, String psMajor, CCurriculum cCurr)
    {
    	this.sMajor = psMajor;
    	this.nCode = pnCode;
    	this.sAddress = psAddr;
    	this.sEmail = psEmail;
    	this.sID = psID;
    	this.sLastName=psLastName;
    	this.sName = psName;
    	this.sResponsibleName=psResponsibleName;
    	this.sResponsibleTel=psResponsibleTel;
    	this.sTelNum=psTelNum;
    	this.sTypeID=psTypeID;
    	this.vrfMyFolder = new CVirtualFolder(cCurr);    
    	this.fSemestralAverage = new float[10];
    	for(int i = 0; i < 10; i++)
    		this.fSemestralAverage[i] = 0;
    	this.nSemester = 1;    	
    }
    
    /**
     * @@brief: Changes student personal info 
     * @@pre: true    
     * @@post: The personal info is changed
     * @@param: String psTelNum
     * @@param: String psAddress
     * @@param: String psEmail
     * @@param: String psResponsibleName
     * @@param: String psResponsibleTelNone   
     * @@aditional_description: None  
     */
    
    public void setPersonalInfo (String psTelNum, String psAddress, String psEmail, String psResponsibleName, String psResponsibleTel)
    {
    	if (psTelNum != "")
    		sTelNum = psTelNum;
    	
    	if (psAddress != "")
    		sAddress = psAddress;
    	
    	if (psEmail != "")
    		sEmail = psEmail;
    	
    	if (psResponsibleName != "")
    		sResponsibleName = psResponsibleName;
    	
    	if (psResponsibleTel != "")
    		sResponsibleTel = psResponsibleTel;
    }
    
    /**
     * @@brief: Retrieves all the courses that the student have seen.
     * 		   The Return is a matrix composed of strings, where column-number + 1 = semester number
     *         and each row represents a course.  
     * @@pre: true    
     * @@post: A string's matrix is returned
     * @@param: None
     * @@return: String[][] Contains the courses already seen.
     * @@aditional_description: None  
     */
    public ArrayList<String> getCoursesAlreadySeen()
    {
		return vrfMyFolder.getCoursesAlreadySeen();    	
    }

    /**
     * @@brief: Retrieves all the courses that the student have seen in the specified semester.
     * 		   The Return is a matrix composed of strings, where each row contains the information of a Course, in the following format:
     *         CourseCode  Name  #Credits  Grade
     * @@pre: The student has seen that semester    
     * @@post: A string's matrix is returned, containing all the student's specified semester information
     * @@param: pnSemester the semester that you want to get information about  
     * @@return: String[][] Contains the courses already seen in the specified semester. null if the semester does not exists or have not been seen.
     * @@aditional_description: None  
     */
    public String[][] getCoursesAlreadySeenSemester(int pnSemester)
    {
		return vrfMyFolder.getCoursesAlreadySeenSemester(pnSemester);    	
    }
 
    /**
     * @@brief: Retrieves the name and last name of the student   
     * @@pre: true    
     * @@post: A string is returned containing name + " "+lastname of the student
     * @@param: None   
     * @@return: String Contains the name and last name of the student
     * @@aditional_description: None 
     */
    
    public String getNameAndLastName()
    {
    	return sName+" "+sLastName;
    }
    
    /**
     * @@brief: Gives the name of a student   
     * @@pre: true    
     * @@post: A string is returned containing the name of the student
     * @@param: None   
     * @@return: String Contains the name of the student
     * @@aditional_description: None 
     */
    public String getName()
    {
    	return sName;
    }
    
    /**
     * @@brief: Gives the last name of a student   
     * @@pre: true    
     * @@post: A string is returned containing the last name of the student
     * @@param: None   
     * @@return: String Contains the last name of the student
     * @@aditional_description: None 
     */
    public String getLastName()
    {
    	return sLastName;
    }
    
    /**
     * @@brief: Gives the ID type of a student   
     * @@pre: true    
     * @@post: A string is returned containing the ID type of the student
     * @@param: None   
     * @@return: String Contains the ID type of the student
     * @@aditional_description: None 
     */
    public String getSTypeID() {
		return sTypeID;
	}
    
    /**
     * @@brief: Retrieves student's telephone number   
     * @@pre: true     
     * @@post: Student's telephone number is returned
     * @@param: None   
     * @@return: String Student's telephone number 
     * @@aditional_description: None  
     */
    public String getStudentTelNum()
    {
    	return sTelNum;
    }
    
    /**
     * @@brief: Retrieves the student's major   
     * @@pre: true     
     * @@post: Student's major is returned
     * @@param: None   
     * @@return: String The student's major 
     * @@aditional_description: none  
     */
    public String getMajor()
    {
    	return sMajor;
    }
    
    /**
     * @@brief: Retrieves student's average grade.    
     * @@pre: true.     
     * @@post: The cumulative average grade of the student is returned.
     * @@param: None.
     * @@return: float The cumulative average.
     * @@aditional_description: None.
     */
    public float getCumulativeAverage()
    {
    	return fCumulativeAverage;
    }
    
    /**
     * @@brief: Retrieves student's responsible name.   
     * @@pre: true.  
     * @@post: Responsible name is returned.
     * @@param: None.  
     * @@return: String The Responsible name.
     * @@aditional_description: None. 
     */
    public String getResponsibleName()
    {
     return sResponsibleName;	
    }
    
    /**
     * @@brief: Retrieves student's responsible telephone number.    
     * @@pre: true.    
     * @@post: The student's responsible telephone number is returned.
     * @@param: None.   
     * @@return: String The Responsible's telephone number. 
     * @@aditional_description: None. 
     */
    public String getResponsibleTelNumber()
    {
    	return sResponsibleTel;
    }
    
    /**
     * @@brief: Retrieves student's address.    
     * @@pre: true.    
     * @@post: The student's address is returned.
     * @@param: None.   
     * @@return: String The student's address. 
     * @@aditional_description: None. 
     */
    public String getAddress()
    {
    	return sAddress;
    }
    
    /**
     * @@brief: Changes the current semester of the student.   
     * @@pre: pnSemester > 0     
     * @@post: Student's current semester is changed.
     * @@param: pnSemester Student's new semester.   
     * @@return: void.
     * @@aditional_description: None.
     * TODO: Can you advance more than one semester?   
     */
    public void setSemester(int pnSemester)
    {
    	nSemester = pnSemester;
    }
    
    /**
     * @@brief: Changes the telephone number of the student for the one in the parameter.   
     * @@pre: pfnCreditNumber > 0    
     * @@post: The credit number is changed
     * @@param: pfNCreditnumber   
     * @@return: void
     * @@aditional_description: None
     * TODO: Is this method really necessary?
     */
    public void setCreditNumber(float pfCreditNumber)
    {
    	
    }
    
    /**
     * @@brief: Adds a course to a student 
     * @@pre: psSubject     
     * @@post: The course is added to the student
     * @@param: psSubject The subject being added    
     * @@return: void
     * @@aditional_description: none
     * TODO: This method will add a subject to the virtual folder, however, it will be implemented in the second cycle  
     */
    public void addSubject(CCourse psSubject)
    {
    	
    }
    
    /**
     * @@brief: Adds a comment to a student   
     * @@pre: True     
     * @@post: Comment added to the student
     * @@param: psNComments A string with comments about the student (he is brilliant, he is a complete asshole, etc.)   
     * @@return: void
     * @@aditional_description: none
     * TODO: Ditto previous one.  
     */
    public void addComments(String psNComments)
    {
    	
    }
    
    /**
     * @@brief: Gives the email of a student   
     * @@pre: true    
     * @@post: A string is returned containing the email of the student
     * @@param: None   
     * @@return: String Contains the email of the student
     * @@aditional_description: None 
     */
    public String getEmail() 
	{
		return sEmail;
		
	}

    /**
     * @@brief: Gives the code of a student   
     * @@pre: true    
     * @@post: A string is returned containing the code of the student
     * @@param: None   
     * @@return: String Contains the code of the student
     * @@aditional_description: None 
     */
	public int getCode() 
	{
		
		return nCode;
	}
	
	/**
	 * @@brief: Returns a String with the serialization of this class, in the format defined   
	 * @@pre: sName != null, sLastName != null, sEmail != null, nCode != 0, sTypeID != null, sID != null,
	 *       sAddress != null, sTelNum != null, sResponsibleName != null, sResponsibleTel != null, nSemester > 0 && <10
	 *       fCumulativeAverage > 0.0, fSemestralAverage != null, sUserName != null, sMajor != null       
	 * @@post: A String containing the serialized object is returned, null otherwise 
	 * @@param: void   
	 * @@return: String Contains the serialized object 
	 * @@aditional_description: none
	 */
	public String serialize ( )
	{
		//Code_Name_lastName_UserName_Major_EMail_TypeID_ID_Address_
		//TelNum_Semester__RName_RTel\nCumulativeA_
		Integer onCode = new Integer(nCode), onSemester = new Integer(nSemester);
		Float ofCumulativeAverage = new Float(fCumulativeAverage);
		/*String sTemp = onCode.toString()+"_"+sName+"_"+"_"+sLastName+"_"+sUserName+"_"+sMajor
			           +"_"+sEmail+"_"+sTypeID+"_"+sID+"_"+sAddress+"_"+sTelNum+"_"+onSemester.toString()
			           +"_"+sResponsibleName+"_"+sResponsibleTel+"\n"+ofCumulativeAverage.toString()+"_";*/
		String sTemp = onCode.toString()+"_"+sName+"_"+sLastName+"_"+sMajor
        +"_"+sEmail+"_"+sTypeID+"_"+sID+"_"+sAddress+"_"+sTelNum+"_"+onSemester.toString()
        +"_"+sResponsibleName+"_"+sResponsibleTel+"\n"+ofCumulativeAverage.toString()+"_";
		//A_NUMSEMESTERS_PROM1_PROM2_..._PROMNUMSEMESTERS
		//We are presuming that the good students has not seen more semester than the current one, in other words
		//He has not seen more or less than nSemester-1
		sTemp += onSemester.toString()+"_";
		int nTemp = nSemester;  
		for(int i = 0; i < nTemp; i++)
		{
			Float ofTemp = new Float(fSemestralAverage[i]);
			sTemp += ofTemp.toString();
			if(i != nTemp - 1)
			{
				sTemp += "_";
			}
		}		
		return sTemp;//Remember, print sTemp with println, because it has no \n
	}
	
	public StringBuilder serializeVirtualFolder ( )
	{
		//StringBuilder sbTemp = new StringBuilder(nCode);ERROR BIG ERROR. This constructor builds a String Builder with that capacity!
		StringBuilder sbTemp = new StringBuilder();
		sbTemp.append(nCode);
		sbTemp.append('\n');
		return sbTemp.append(vrfMyFolder.serialize());
	}
	
	/**
     * @@brief: Retrieves student's semestral average of the specified semester.    
     * @@pre: pnSemester < nSemester .    
     * @@post: The student's semestral average is returned.
     * @@param: pnSemester Semester.   
     * @@return: float The student's semestarl average in the semester nSemester 
     * @@aditional_description: None. 
     */
    public float getAverageSemester (int pnSemester)
    {
    	return fSemestralAverage[pnSemester - 1];
    }

    /**g
     * @@brief: Gives the ID(identification document) of a student   
     * @@pre: true    
     * @@post: A string is returned containing the ID(identification document) of the student
     * @@param: None   
     * @@return: String Contains the ID(identification document) of the student
     * @@aditional_description: None 
     */
	public String getID() 
	{		
		return sID;
	}	
	
	 /**
     * @@brief: Gives the actual curriculum   
     * @@pre: The curriculum exist    
     * @@post: The actual curriculum is given
     * @@param: None   
     * @@return: String [][] (Contains the courses of the curriculum)
     * @@aditional_description: None 
     */
	public String[][] getCurriculum()
	{ 
		return vrfMyFolder.getCurriculum();		
	}

	 /**
     * @@brief: Changes the semester of a course   
     * @@pre: The course exist    
     * @@post: If is possible the semester of the course is changed. Shows the
     * 		  result(true or false)
     * @@param: psCourse
     * @@param: pnNewSemester   
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public CodRes changeSemesterOfACourse(int pnSemester, int pnColumn, boolean bUp)
	{
		return vrfMyFolder.changeSemesterOfACourse( pnSemester, pnColumn, bUp);		
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
		return vrfMyFolder.addCourseToSee(psCode, psName, pfCred, pnSemester);
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
		return vrfMyFolder.deleteCourseToSee(pnSemester, pnColumn);
	}
	
	/**
     * @@brief: Verifies if the student ends his career   
     * @@pre: true    
     * @@post: You know if the student realy finish his career
     * @@param: none
     * @@return: boolean (true or false)
     * @@aditional_description: None 
     */
	public boolean verifyEndOfCareer ()
	{
		return vrfMyFolder.verifyEndOfCareer();
	}	

	/**
	 * @@brief: Gets the body of a message  
	 * @@pre: The body of the message exist	
	 * @@post: The body of the message is received
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the body of the message) 
	 */
	public ArrayList<String> getMessagesBody() 
	{
		return vrfMyFolder.getMessagesBody();
	}
	
	/**
	 * @@brief: Gets the content of the student faults  
	 * @@pre: True	
	 * @@post: The faults of the student are seen
	 * @@param: void
	 * @@return: ArrayList<String> (Contain the student faults) 
	 */
	public ArrayList<String> getFaultsBody() 
	{
		return vrfMyFolder.getFaultsBody();
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
	public void receiveMessage(String psFrom, String psSubject, String psMessage) 
	{
		vrfMyFolder.receiveMessage(psFrom, psSubject, psMessage);		
	}

	/**
	 * @@brief: Receives a fault of the student  
	 * @@pre: True
	 * @@post: The student fault is received
	 * @@param: psForm
	 * @@param: psSubject
	 * @@param: psMessage
	 * @@return: void 
	 */
	public void receiveFault(String psFrom, String psSubject, String psMessage) 
	{
		vrfMyFolder.receiveFault(psFrom, psSubject, psMessage);		
	}
	
	/**
	 * @@brief: Gets the specific message  
	 * @@pre: The message exist	
	 * @@post: The especific message is received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificMessage(String psId) 
	{		
		return vrfMyFolder.getSpecificMessage(psId);
	}
	
	/**
	 * @@brief: Gets the specification of the faults  
	 * @@pre: True	
	 * @@post: The especifications of the faults are received
	 * @@param: psId
	 * @@return: String 
	 */
	public String getSpecificFault(String psId) 
	{		
		return vrfMyFolder.getSpecificFault(psId);
	}

	/**
	 * @@brief: Gets the planned curriculum  
	 * @@pre: True	
	 * @@post: The planned curriculum is given
	 * @@param: void
	 * @@return: String [][] 
	 */
	public String[][] getPlannedCurriculum() 
	{		
		return vrfMyFolder.getPlannedCurriculum();
	}

	/**
	 * @@brief: Adds a course to the planned curriculum  
	 * @@pre: The curriculum exist	
	 * @@post: A course is added to the planned curriculum
	 * @@param: psCourseCode
	 * @@param: psName
	 * @@param: pfCredit
	 * @@param: pnSemester
	 * @@return: CodRes 
	 */
	public CodRes addCourseToPlannedCurriculum(String psCourseCode, String psName, float pfCred, int pnSemester) 
	{		
		return vrfMyFolder.addCourseToSee(psCourseCode, psName, pfCred, pnSemester);
	}
}