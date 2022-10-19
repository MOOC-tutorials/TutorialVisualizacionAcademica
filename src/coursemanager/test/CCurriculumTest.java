package coursemanager.test;

import java.util.ArrayList;

import coursemanager.model.CCoreq;
import coursemanager.model.CCourse;
import coursemanager.model.CCurriculum;
import coursemanager.model.CPrereq;


import junit.framework.TestCase;


public class CCurriculumTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CCurriculumTest.class);
	}
	
	public CCurriculum curriculum;
	
	protected void setUp() throws Exception {
		
		curriculum = new CCurriculum();		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddSearchCourse()
	{
		String nName = "Ingenieria de Software";
		String sCode = "ISIS2701";
		String sType = "OBL";
		float fCred = (float) 3.0;
		int nLev = 2;

		CCourse newCourse = new CCourse(nName, sCode, fCred, nLev, sType);
		curriculum.addCourse(newCourse);
		this.assertEquals(newCourse, curriculum.getCourse(sCode));		
	}
	
	public void testGetCourseInexistent()
	{
		this.assertEquals(null, curriculum.getCourse("ISIS2701"));
	}
	
	public void testDelete()
	{
		String sCode = "ISIS2701";
		testAddSearchCourse();
		curriculum.deleteCourse(sCode);
		this.assertTrue(curriculum.getCourse("Ingenieria de Software") == null);		
	}
	
	public void testAddPrereq()
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		curriculum.addCourse(newCourse);
		CCourse newCourse2 = new CCourse("Arq Softaware", "ISIS2711", (float)3.0, 2, "OBL");
		curriculum.addCourse(newCourse2);
		CPrereq preReq = new CPrereq("ISIS2701", "ISIS2711");
		ArrayList listPre = new ArrayList();
		curriculum.addPrereq(preReq);
		
		curriculum.getPrereqs("ISIS2711", listPre);
		
		String proof = (String)listPre.get(0);
		
		this.assertTrue(proof == "ISIS2701");
		
	}
	
	public void testAddCoreq()
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		curriculum.addCourse(newCourse);
		CCourse newCourse2 = new CCourse("Arq Softaware", "ISIS2702", (float)3.0, 2, "OBL");
		curriculum.addCourse(newCourse2);
		CCoreq coReq = new CCoreq("ISIS2701", "ISIS2702");
		ArrayList listCoreq = new ArrayList();
		curriculum.addCoreq(coReq);
		
		curriculum.getCoreqs("ISIS2701", listCoreq);
		
		String proof = (String)listCoreq.get(0);
		
		this.assertTrue(proof == "ISIS2702");
		
	}
	
	public void testGetAllCourses()
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		curriculum.addCourse(newCourse);
		
		ArrayList arrSCodes = new ArrayList();
		ArrayList arrSCourses = new ArrayList();
		
		curriculum.getAllCourses(arrSCodes, arrSCourses);
		
		String sCode = (String)arrSCodes.get(0);
		String sCourse = (String)arrSCourses.get(0); 
		
		this.assertTrue(sCode == "ISIS2701");
		this.assertTrue(sCourse == "Ing Software");
		
	}
}
