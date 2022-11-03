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
	
	public void testGetAcademicPRogram()
	{
		//devuelve algo de tipo CAcademicProgram
	}
	
	
	public void testGetName()
	{
		this.assertEquals("ingenieria",faculty.getName());
	}

}
