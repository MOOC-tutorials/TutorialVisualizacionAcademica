package coursemanager.test;

import coursemanager.model.CCourse;
import junit.framework.TestCase;

public class CCourseTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CCourseTest.class);
	}

	public CCourse CCour;
	
	protected void setUp() throws Exception 
	{
		CCour = new CCourse();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGettersSetters()
	{
		float fCredNumber = (float)3.0;
		int nLev = 2;
		String sCod = "ISIS2701";
		String sNam = "Ingenieria de Software";
		String sTyp = "OBL";
		
		CCour.setNCreditNumber(fCredNumber);
		CCour.setNLevel(nLev);
		CCour.setSCode(sCod);
		CCour.setSName(sNam);
		CCour.setSType(sTyp);
		
		this.assertEquals(fCredNumber, CCour.getNCreditNumber());
		this.assertEquals(nLev, CCour.getNLevel());
		this.assertEquals(sCod, CCour.getSCode());
		this.assertEquals(sNam, CCour.getSName());
		this.assertEquals(sTyp, CCour.getSType());
	}
	
	public void testSetInvalidNameLevel() 
	{
		testGettersSetters();
		CCour.set("", 4, 0);
		this.assertEquals("Ingenieria de Software", CCour.getSName());
		this.assertTrue(4 == CCour.getNCreditNumber());
		this.assertTrue( 2 == CCour.getNLevel());
	}
}
