package coursemanager.test;

import coursemanager.model.CDepartment;
import coursemanager.model.CFaculty;
import coursemanager.model.CodRes;
import junit.framework.TestCase;

public class CFacultyTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CFacultyTest.class);
	}
	
	public CFaculty faculty;

	protected void setUp() throws Exception {
		faculty = new CFaculty("ingenieria");
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetDepartmentFormAcademiProgram()
	{
		CDepartment depart = new CDepartment("ingenieria");
		faculty.addDepartment("ingnieria");
		depart.addAcademicProgram("ing sist", "ISIS");
		this.assertEquals(depart, faculty.getDepartmentFromAcadProg("ing sist"));
	}
	
	public void testAddGetDepartment()
	{
		CodRes res;
		String sName = "Ingenieria Civil y Ambiental"; 
		res = faculty.addDepartment(sName);
		this.assertTrue(res == CodRes.SUCCESS);
		
		res = faculty.addDepartment(sName);
		this.assertTrue(res == CodRes.ALREADY_EXISTS);			
	}
	
	public void testGetDepartment()
	{
		//devuelve algo de tipo CDepartment
		CDepartment depart = new CDepartment("ingenieria");
		faculty.addDepartment("ingenieria");
		this.assertEquals(depart, faculty.getDepartment("ingenieria"));
	}
	
	public void testGetAcademicPRogram()
	{
		//devuelve algo de tipo CAcademicProgram
	}
	
	public void testAddDepartmentOK()
	{
		CodRes res;
		String sName = "Ingenieria Civil y Ambiental"; 
		res = faculty.addDepartment(sName);
		this.assertTrue(res == CodRes.SUCCESS);
	}
	
	public void testAddDepartmentAlreadyExist()
	{
		CodRes res;
		String sName = "Ingenieria Civil y Ambiental"; 
		res = faculty.addDepartment(sName);
		this.assertTrue(res == CodRes.SUCCESS);
		
		res = faculty.addDepartment(sName);
		this.assertTrue(res == CodRes.ALREADY_EXISTS);			
	}
	
	public void testGetName()
	{
		this.assertEquals("ingenieria",faculty.getSName());
	}

}
