package salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import salesforce.configfile.projectconfig;
import salesforce.pages.HomePage;
import salesforce.pages.LeadPage;
import salesforce.pages.loginPage;

public class LeadTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void Start() {
		createReport();
		launchApp();
	}

	@Test
	public void CreateNewLead() {
		logger = report.startTest("CreateNewLead");
		loginPage lp = new loginPage(driver, logger);
		HomePage hp = lp.validLogin(projectconfig.username, projectconfig.password);
		boolean val = hp.verifyLogoutLink();
		Assert.assertEquals(val, true);
		hp.ClickLeads();
		LeadPage lead = new LeadPage(driver, logger);
		lead.CreateLead("Tyler", "Kelly", "Riverrun");
		logger.log(LogStatus.PASS, "Lead created successfully");
		report.endTest(logger);
		report.flush();

	}

	@AfterClass
	public void Stop() {
		closeApp();
	}

}
