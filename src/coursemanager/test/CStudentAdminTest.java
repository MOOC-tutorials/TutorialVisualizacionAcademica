package coursemanager.test;

import coursemanager.model.CStudent;
import coursemanager.model.CStudentAdmin;
import junit.framework.TestCase;


public class CStudentAdminTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CStudentAdminTest.class);
	}

	public CStudentAdmin adminStud;
	
	protected void setUp() throws Exception {
		adminStud = new CStudentAdmin();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}



