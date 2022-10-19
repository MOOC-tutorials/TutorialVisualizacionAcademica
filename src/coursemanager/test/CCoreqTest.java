package coursemanager.test;

import coursemanager.model.CCoreq;
import junit.framework.TestCase;


public class CCoreqTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CCoreqTest.class);
	}
	
	public CCoreq CCor;

	protected void setUp() throws Exception {
		CCor = new CCoreq();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testGettersSetters()
	{
		String sC1 = "ISIS2000";
		String sC2 = "ISIS2321";
		CCor.setSCourse1(sC1);
		CCor.setSCourse2(sC2);
		
		this.assertEquals(sC1, CCor.getSCourse1());
		this.assertEquals(sC2, CCor.getSCourse2());		
	}

}
