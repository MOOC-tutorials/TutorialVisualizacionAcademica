package coursemanager.test;

import coursemanager.model.CPrereq;
import junit.framework.TestCase;


public class CPrereqTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CPrereqTest.class);
	}
	
	public CPrereq CPre;

	protected void setUp() throws Exception {
		
		CPre = new CPrereq();

		try {
			super.setUp();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSettersGetters()
	{
		String sPre = "ISIS2000";
		String sCour = "ISIS3111";
		
		CPre.setSCourse(sCour);
		CPre.setSPreReq(sPre);
		
		this.assertEquals(sPre, CPre.getSPreReq());
		this.assertEquals(sCour, CPre.getSCourse());		
	}

}