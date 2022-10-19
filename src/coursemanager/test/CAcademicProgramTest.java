package coursemanager.test;

import java.util.ArrayList;

import coursemanager.model.CAcademicProgram;
import coursemanager.model.CCoreq;
import coursemanager.model.CCourse;
import coursemanager.model.CPrereq;
import coursemanager.model.CodRes;


import junit.framework.TestCase;

public class CAcademicProgramTest extends TestCase
{

	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(CAcademicProgramTest.class);
	}

	public CAcademicProgram CAcademicProg;
		
	protected void setUp() throws Exception 
	{
		super.setUp();
		CAcademicProg = new CAcademicProgram("Ingenieria de Sistemas y Computacion","ISIS");
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testAddCourseCurriculumOK()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testAddCourseCurriculumTwice()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		CodRes res2 = CAcademicProg.addCourseCurriculum(course);
		
		this.assertEquals(res2, CodRes.ALREADY_EXISTS);
	}
	
	public void testDeleteCourseCurriculumOK()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		CodRes res2 = CAcademicProg.deleteCourseCurriculum("ISIS27101");

		this.assertEquals(res2, CodRes.SUCCESS);
	}
	
	public void testFindCourse() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		this.assertEquals(course, CAcademicProg.findCourse("ISIS2701"));
	}
	
	public void testAddPreRuleOK() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		this.assertEquals(res, CodRes.SUCCESS);
	}

	public void testAddPreRuleNotInCurriculum() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);

		res = CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		this.assertEquals(res, CodRes.NOT_IN_CURRICULUM);
	}

	public void testAddPreRuleAlreadyExist() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		res = CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		
		this.assertEquals(res, CodRes.ALREADY_EXISTS);
	}

	public void testAddCorrRuleOK() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		this.assertEquals(res, CodRes.SUCCESS);
	}

	public void testAddCorrRuleNotInCurriculum() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		this.assertEquals(res, CodRes.NOT_IN_CURRICULUM);
	}

	public void testAddCorrRuleAlreadyExist() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		res = CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		this.assertEquals(res, CodRes.ALREADY_EXISTS);
	}
	
	public void testAddAreaRuleOK() 
	{
		CCourse course = new CCourse ("HDF", "ISIS2703", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addAreaRule("electiva", "HDF", 5);
		this.assertEquals(res, CodRes.NEW_RULE);
	}

	public void testAddAreaRuleAlreadyExist() 
	{
		CCourse course = new CCourse ("HDF", "ISIS2703", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		course = new CCourse ("HD", "ISIS2704", (float)3.0, 2, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addAreaRule("electiva", "HDF", 5);
		res = CAcademicProg.addAreaRule("electiva", "HD", 5);
		
		this.assertEquals(res, CodRes.SUCCESS);
	}	
	
	public void testDeletePreRuleOK() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		res = CAcademicProg.deletePreRule("ISIS2701", "ISIS2711");
		
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testDeletePreRuleError() 
	{
		CodRes res = CAcademicProg.deletePreRule("ISIS2701", "ISIS2711");
		
		this.assertEquals(res, CodRes.ERROR);
	}
	
	public void testDeleteCorrRuleOK() 
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		course = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		res = CAcademicProg.deleteCorRule("ISIS2701", "ISIS2702");
		
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testDeleteCorrRuleError() 
	{
		CodRes res = CAcademicProg.deleteCorRule("ISIS2701", "ISIS2702");
		
		this.assertEquals(res, CodRes.ERROR);
	}
	
	public void testDeleteRuleAreaOK() 
	{
		CCourse course = new CCourse ("HDF", "ISIS2703", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);
		
		res = CAcademicProg.addAreaRule("electiva", "HDF", 5);		
		res = CAcademicProg.deleteRuleArea("electiva", "HDF");
		
		this.assertEquals(res, CodRes.SUCCESS);
	}
	
	public void testDeleteRuleAreaInexistent() 
	{
		CCourse course = new CCourse ("HDF", "ISIS2703", (float)3.0, 2, "OBL");
		CodRes res = CAcademicProg.addCourseCurriculum(course);

		res = CAcademicProg.deleteRuleArea("elec", "HDF");
		
		this.assertEquals(res, CodRes.ERROR);
	}

	public void testGetNameCode()
	{
		this.assertEquals("ISIS", CAcademicProg.getNameCode());
	}

	public void testGetCurriculumCourses() 
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		CAcademicProg.addCourseCurriculum(newCourse);
		
		ArrayList arrSCodes = new ArrayList();
		ArrayList arrSCourses = new ArrayList();
		
		CAcademicProg.getCurriculumCourses(arrSCodes, arrSCourses);
		
		String sCode = (String)arrSCodes.get(0);
		String sCourse = (String)arrSCourses.get(0); 
		
		this.assertTrue(sCode == "ISIS2701");
		this.assertTrue(sCourse == "Ing Software");
		
		
	}

	public void testGetListPrereqs() 
	{
		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		CAcademicProg.addCourseCurriculum(newCourse);
		CCourse newCourse2 = new CCourse("Arq Softaware", "ISIS2711", (float)3.0, 2, "OBL");
		CAcademicProg.addCourseCurriculum(newCourse2);

		CPrereq preReq = new CPrereq("ISIS2701", "ISIS2711");
		
		ArrayList listPrereq = new ArrayList();
		CAcademicProg.addPreRule("ISIS2701", "ISIS2711");
		
		CAcademicProg.getListPrereqs("ISIS2711", listPrereq);
				
		String proof = (String)listPrereq.get(0);
		
		this.assertTrue(proof == "ISIS2701");
		
	}

	public void testGetListCoreqs() 
	{

		CCourse newCourse = new CCourse("Ing Software", "ISIS2701", (float)3.0, 2, "OBL");
		CAcademicProg.addCourseCurriculum(newCourse);
		CCourse newCourse2 = new CCourse("Arq Softaware", "ISIS2702", (float)3.0, 2, "OBL");
		CAcademicProg.addCourseCurriculum(newCourse2);

		CCoreq coReq = new CCoreq("ISIS2701", "ISIS2702");
		
		ArrayList listCoreq = new ArrayList();
		CAcademicProg.addCorrRule("ISIS2701", "ISIS2702");
		
		CAcademicProg.getListCoreqs("ISIS2701", listCoreq);
				
		String proof = (String)listCoreq.get(0);
		
		this.assertTrue(proof == "ISIS2702");
	}
}
