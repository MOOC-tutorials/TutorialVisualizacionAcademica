package coursemanager.test;

import coursemanager.controller.CManager;
import coursemanager.model.CAcademicProgram;
import coursemanager.model.CDepartment;
import coursemanager.model.CodRes;
import junit.framework.TestCase;

public class CManagerTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CManagerTest.class);
	}
	
	public CManager manager;

	protected void setUp() throws Exception {
		super.setUp();
		manager = new CManager();
		manager.setSTempAcadProg("ISIS");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddStudentOK()
	{
		CodRes res = manager.addStudent("Luis Miguel", "Perez D.", "yo@@yo.com", 200321051, "Cra bla", "CED", "8081629x", "3152940647", "Ama", "300 xxx xxxx", "ISIS");
		this.assertTrue(res == CodRes.SUCCESS);
	}
	
	public void testAddStudentTwice()
	{
		CodRes res = manager.addStudent("Luis Miguel", "Perez D.", "yo@@yo.com", 200321051, "Cra bla", "CED", "8081629x",  "3152940647", "Ama", "300 xxx xxxx", "ISIS");
		res = manager.addStudent("Luis Miguel", "Perez D.", "yo@@yo.com", 200321051, "Cra bla", "CED", "8081629x",  "3152940647", "Ama", "300 xxx xxxx", "ISIS");
		this.assertEquals(res, CodRes.ALREADY_EXISTS);		
	}
	
	public void testCreateCourses()
	{
		String psName = "Ingenieria de Software";
		String psCode = "ISIS2701";
		float pfCreditNumber = (float)3.0;
		int pnLevel = 2;
		String psArchive = "ISIS";
		String psType = "OBL";
		CodRes res = manager.createCourse(psName, psCode, pfCreditNumber, pnLevel, psType, psArchive);
		this.assertTrue(res == CodRes.SUCCESS);
		
		psName = "Estructuras de Datos";
		psCode = "ISIS2101";
		pfCreditNumber = (float)3.0;
		pnLevel = 2;
		psArchive = "ISIS";
		res = manager.createCourse(psName, psCode, pfCreditNumber, pnLevel, psType, psArchive);
		this.assertTrue(res == CodRes.SUCCESS);		
		
	}
	
	public void testCreateCourseWrongData()
	{
		String psName = "";
		String psCode = "ISIS2701";
		float pfCreditNumber = (float)3.0;
		int pnLevel = 2;
		String psArchive = "ISIS";
		String psType = "OBL";
		CodRes res = manager.createCourse(psName, psCode, pfCreditNumber, pnLevel, psType, psArchive);
		this.assertTrue(res == CodRes.INVALID_ARGUMENTS);		
	}
	
	public void testCreateCourseWrongCredits()
	{
		String psName = "";
		String psCode = "ISIS2701";
		float pfCreditNumber = (float)2.6;
		int pnLevel = 2;
		String psArchive = "ISIS";
		String psType = "OBL";
		CodRes res = manager.createCourse(psName, psCode, pfCreditNumber, pnLevel, psType, psArchive);
		this.assertTrue(res == CodRes.INVALID_ARGUMENTS);		
	}
	
	public void testAddCoursesCurriculumOK()
	{
		String psFromAcadProg = "ISIS";
		String psCode = "ISIS2701";
		String pnArchive = "ISIS";
		testCreateCourses();
		CodRes res = manager.addCourseToCurriculum(psFromAcadProg, psCode, pnArchive);
		this.assertTrue(res == CodRes.SUCCESS);
		
		psFromAcadProg = "ISIS";
		psCode = "ISIS2101";
		pnArchive = "ISIS";

		res = manager.addCourseToCurriculum(psFromAcadProg, psCode, pnArchive);
		this.assertTrue(res == CodRes.SUCCESS);				
	}
	
	public void testAddCoursesCurriculumTwice()
	{
		String psFromAcadProg = "ISIS";
		String psCode = "ISIS2701";
		String pnArchive = "ISIS";
		testCreateCourses();
		CodRes res = manager.addCourseToCurriculum(psFromAcadProg, psCode, pnArchive);
		this.assertTrue(res == CodRes.SUCCESS);
		
		psFromAcadProg = "ISIS";
		psCode = "ISIS2701";
		pnArchive = "ISIS";

		res = manager.addCourseToCurriculum(psFromAcadProg, psCode, pnArchive);
		this.assertTrue(res == CodRes.ALREADY_EXISTS);				
	}
	
	public void testAddPreCorRuleOK()
	{
		String psCourse1 = "ISIS2101";
		String psCourse2 = "ISIS2701";
		String psType = "PRE";
		String psArchive = "ISIS"; 
		testAddCoursesCurriculumOK();
		CodRes res = manager.addRule(psCourse1, psCourse2, psType, psArchive);
		this.assertTrue( res == CodRes.SUCCESS);				
	}
	
	public void testAddPreCorRuleWithInexistentCourse()
	{
		String psCourse1 = "ISIS2999";   //Not exists in curriculum.
		String psCourse2 = "ISIS2701";
		String psType = "PRE";
		String psArchive = "ISIS"; 
		testAddCoursesCurriculumOK();
		CodRes res = manager.addRule(psCourse1, psCourse2, psType, psArchive);
		this.assertTrue( res == CodRes.NOT_IN_CURRICULUM);				
	}
	
	public void testAddRepeatedRule()
	{
		testAddPreCorRuleOK();
		
		String psCourse1 = "ISIS2101";
		String psCourse2 = "ISIS2701";
		String psType = "PRE";
		String psArchive = "ISIS"; 
		CodRes res = manager.addRule(psCourse1, psCourse2, psType, psArchive);
		this.assertTrue( res == CodRes.ALREADY_EXISTS);			
	}
	
	public void testVerifyAddingStudent()
	{
		testAddStudentOK();
		this.assertTrue(manager.verifyCode(200321051));
		
	}
	
	public void testSetInfoCourseOK()
	{
		testCreateCourses();
		manager.setSTempAcadProg("ISIS");
		CodRes res = manager.setInfoCourse("Ingenieria de SW", (float)3.0, "ISIS2701", 2);
		this.assertTrue( res == CodRes.SUCCESS);
	}
	
	public void testDeleteCourseOK()
	{		
		testCreateCourses();
		manager.deleteCourse("ISIS2701");
		manager.deleteCourse("ISIS2101");
		testCreateCourses();		
	}
	
	public void testDeleteFromCurriculumOK()  //This test is more precise in CCurriculum.
	{
		testAddCoursesCurriculumOK();
		CodRes res = manager.deleteCourseFromCurriculum("ISIS2701");
		this.assertTrue( res == CodRes.SUCCESS);
	}

}
