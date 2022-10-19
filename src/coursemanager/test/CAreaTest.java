package coursemanager.test;

import coursemanager.model.CArea;
import coursemanager.model.CodRes;
import junit.framework.TestCase;

public class CAreaTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CAreaTest.class);
	}

	public CArea CAr;

	protected void setUp() throws Exception {
		super.setUp();
		CAr = new CArea("cbu", 5, "literatura en el tiempo");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetNCoursesNumber( )
	{
		this.assertEquals(5, CAr.getNCoursesNumber());
	}

	public void testGetSName ( )
	{
		this.assertEquals("cbu", CAr.getSName());
	}
	
	public void testAddRuleOK ()
	{
		CodRes res = CAr.addRule("Educacion y ciencia");
		this.assertTrue(res == CodRes.SUCCESS);
	}
	
	public void testAddRuleAlreadyExist ()
	{
		CodRes res = CAr.addRule("literatura en el tiempo");
		this.assertTrue(res == CodRes.ALREADY_EXISTS);
	}
	
	public void testDeleteCourseOK()
	{
		CodRes res = CAr.deleteCourse("literatura en el tiempo");
		this.assertTrue(res == CodRes.SUCCESS);
	}
	
	public void testDeleteCourseInexistent()
	{
		CodRes res = CAr.deleteCourse("literatura en el tiempo");
		res = CAr.deleteCourse("literatura en el tiempo");
		this.assertTrue(res == CodRes.INEXISTENT);
	}
	
	public void testExistsCourse ()
	{
		this.assertEquals(true, CAr.existsCourse("literatura en el tiempo"));
	}
}
