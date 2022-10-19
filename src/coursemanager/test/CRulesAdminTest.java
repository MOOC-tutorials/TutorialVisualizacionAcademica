package coursemanager.test;

import coursemanager.model.CArea;
import coursemanager.model.CCoreq;
import coursemanager.model.CCourse;
import coursemanager.model.CPrereq;
import coursemanager.model.CRulesAdmin;
import coursemanager.model.CodRes;
import junit.framework.TestCase;

public class CRulesAdminTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CRulesAdminTest.class);
	}

	public CRulesAdmin CRulesAd;

	protected void setUp() throws Exception {
		super.setUp();
		CRulesAd = new CRulesAdmin();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddSearchPreRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		
		CPrereq newRule = CRulesAd.addPreRule("ISIS2701", "ISIS2711");
		
		this.assertEquals(newRule, CRulesAd.searchPreRule("ISIS2701", "ISIS2711"));
	}
	
	public void testAddSearchCorRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		
		CCoreq newRule = CRulesAd.addCorRule("ISIS2701", "ISIS2702");
		this.assertEquals(newRule, CRulesAd.searchCorRule("ISIS2701", "ISIS2702"));
	}
	
	public void testAddSearchAreaRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		
		CArea newRule = CRulesAd.addAreaRule("cbu", "ISIS2701", 5);
		this.assertEquals(newRule, CRulesAd.searchAreaRule("cbu"));
	}
	
	public void testDeletePreRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		
		CPrereq newRule = CRulesAd.addPreRule("ISIS2701", "ISIS2711");
		
		CodRes res = CRulesAd.deletePreRule("ISIS2701", "ISIS2711");
		this.assertEquals(res, CodRes.SUCCESS);		
	}
	
	public void testDeletePreRuleError()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Arquitectura de Software", "ISIS2711", (float)3.0, 3, "OBL");
		
	    CodRes res = CRulesAd.deletePreRule("ISIS2701", "ISIS2711");
		this.assertEquals(res, CodRes.ERROR);		
	}	
	
	public void testDeleteCorRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		
		CCoreq newRule = CRulesAd.addCorRule("ISIS2701", "ISIS2702");
		
		CodRes res = CRulesAd.deleteCorRule("ISIS2701", "ISIS2702");
		this.assertEquals(res, CodRes.SUCCESS);		
	}
	
	public void testDeleteCorRuleError()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		CCourse course2 = new CCourse ("Bases de datos", "ISIS2702", (float)3.0, 3, "OBL");
		
	    CodRes res = CRulesAd.deleteCorRule("ISIS2701", "ISIS2702");
		this.assertEquals(res, CodRes.ERROR);		
	}
	
	public void testDeleteAreaRule()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		
		CArea newRule = CRulesAd.addAreaRule("cbu", "ISIS2701", 5);
		
		CodRes res = CRulesAd.deleteAreaRule("cbu", "ISIS2701");
		this.assertEquals(res, CodRes.SUCCESS);		
	}
	
	public void testDeleteAreaRuleError()
	{
		CCourse course = new CCourse ("Ingenieria de Software", "ISIS2701", (float)3.0, 2, "OBL");
		
		CodRes res = CRulesAd.deleteAreaRule("cbu", "ISIS2701");
		
	    this.assertEquals(res, CodRes.ERROR);		
	}
	
}
