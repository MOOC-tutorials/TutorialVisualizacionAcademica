package coursemanager.test;

import coursemanager.model.CStudent;
import junit.framework.TestCase;

public class CStudentTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CStudentTest.class);
	}

	public CStudent CStud;
	
	protected void setUp() throws Exception 
	{
		CStud = new CStudent("Luis Miguel", "Perez D.", 200321051, "a@@yahoo.com", "CED", "8081629x", "Cra bla", "3152940647", "Ama", "300 xxx xxxx", "ISIS", null);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetPersonalInfo()
	{
		CStud.setPersonalInfo("1234567", "cra 28", "a@@hotmail.com", "Fanny", "7654321");
		
		this.assertEquals("Luis Miguel Perez D.", CStud.getNameAndLastName());
		this.assertEquals("1234567", CStud.getStudentTelNum());
		this.assertEquals("Fanny", CStud.getResponsibleName());
		this.assertEquals("7654321", CStud.getResponsibleTelNumber());
		this.assertEquals("cra 28", CStud.getAddress());
	}
}

