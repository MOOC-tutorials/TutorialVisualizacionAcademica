package coursemanager.test;

import java.util.ArrayList;

import coursemanager.model.CAcademicProgram;
import coursemanager.model.CCourse;
import coursemanager.model.CDepartment;
import coursemanager.model.CodRes;


import junit.framework.TestCase;

public class CDepartmentTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CDepartmentTest.class);
	}

	public CDepartment CDepart;

	protected void setUp() throws Exception {
		super.setUp();
		CDepart = new CDepartment("ingenieria");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddAcademicProgramOK()
	{
		CodRes res = CDepart.addAcademicProgram("Ingenieria de Sistemas y Computacion", "ISIS");
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testAddAcademicProgramAlreadyExist()
	{
		CodRes res = CDepart.addAcademicProgram("Ingenieria de Sistemas y Computacion", "ISIS");
		res = CDepart.addAcademicProgram("Ingenieria de Sistemas y Computacion", "ISIS");
		this.assertEquals(res, CodRes.ALREADY_EXISTS);
	}

	public void testAddCourseOK()
	{
		CodRes res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testAddCourseAlreadyExist()
	{
		CodRes res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		this.assertEquals(res, CodRes.ALREADY_EXISTS);
	}
	
	public void testSetInfoCourseOK()
	{
		CodRes res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		res = CDepart.setInfoCourse("ingenieria de Soft", (float)3.5, "ISIS2701", 3);
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testSetInfoCourseInexistent()
	{
		CodRes res = CDepart.setInfoCourse("ingenieria de Soft", (float)3.5, "ISIS2710", 3);
		this.assertEquals(res, CodRes.INEXISTENT);
	}
	
	public void testGetAcademicProgramOK()
	{
		CodRes res = CDepart.addAcademicProgram("Ingenieria de Sistemas y Computacion", "ISIS");
		CAcademicProgram acaProg = CDepart.getAcademicProgram("ISIS");
		this.assertEquals("ISIS", acaProg.getNameCode());
		
	}
	
	public void testGetAcademicProgramNull()
	{
		CAcademicProgram acaProg = CDepart.getAcademicProgram("ISI");
		this.assertEquals(null, acaProg);
	}
	
	public void testSearchCourseOk()
	{
		CodRes res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		this.assertEquals("Ingenieria de Software", CDepart.searchCourse("ISIS2701").getSName());
	}
	
	public void testSearchCourseNull()
	{
		CCourse course = CDepart.searchCourse("ISIS27");
		this.assertEquals(null, course);
	}
	
	public void testDeleteCourseOK()
	{
		CodRes res = CDepart.addCourse("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		res = CDepart.deleteCourse("ISIS2701"); 
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testDeleteCourseError()
	{
		CodRes res = CDepart.deleteCourse("ISIS2710"); 
		this.assertEquals(res, CodRes.ERROR);
	}
	
	public void testGetName()
	{
		this.assertEquals("ingenieria", CDepart.getName());
	}
	
	
	public void testGetAllCourses()
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		CDepart.addCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		
		ArrayList arrSCodes = new ArrayList();
		ArrayList arrSCourses = new ArrayList();
		
		CDepart.getAllCourses(arrSCodes, arrSCourses);
		
		String sCode = (String)arrSCodes.get(0);
		String sCourse = (String)arrSCourses.get(0); 
		
		this.assertTrue(sCode == "ISIS2701");
		this.assertTrue(sCourse == "Ing Software");
		
	}
}
