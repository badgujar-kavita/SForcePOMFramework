package salesforce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import salesforce.commonfunctions.CommonResources;
import salesforce.configfile.projectconfig;
import salesforce.pages.HomePage;
import salesforce.pages.loginPage;

public class LoginTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void Start() {
		createReport();
		launchApp();
	}

	@Test(priority = 0)
	public void verifyLoginPageTitle() throws IOException {
		logger = report.startTest("verifyLoginPageTitle");
		loginPage lp = new loginPage(driver, logger);
		boolean val = lp.verifyTitle();
		if (val) {
			logger.log(LogStatus.PASS, "Title verified");
		} else {

			String filename = CommonResources.getscreenshot("verifyLoginPageTitle", driver);
			logger.log(LogStatus.FAIL, "Title did not match <span class='label total-time'><a href=" + filename
					+ ">Click here for screenshot</span>");
		}

		/*
		 * try { Assert.assertEquals(val, true); } catch (Exception ex) {
		 * System.out.println("Exception" + ex.getMessage()); }
		 */

		report.endTest(logger);
		report.flush();

	}

	@Test(priority = 1)
	public void verifyLoginPageLogo() throws IOException {
		logger = report.startTest("verifyLoginPageLogo");
		loginPage lp = new loginPage(driver, logger);
		boolean val = lp.verifyLogo();
		if (val) {
			logger.log(LogStatus.PASS, "logo verified");
		} else {

			String filename = CommonResources.getscreenshot("verifyLoginPageLogo", driver);
			logger.log(LogStatus.FAIL, "logo does not match <span class='label total-time'><a href=" + filename
					+ ">Click here for screenshot</span>");
		}
		/*
		 * try { Assert.assertEquals(val, true); } catch (Exception ex) {
		 * System.out.println("Exception" + ex.getMessage()); }
		 */
		report.endTest(logger);
		report.flush();

	}

	@Test(priority = 2)
	public void verifyInvalidLogin() {
		logger = report.startTest("verifyInvalidLogin");
		loginPage lp = new loginPage(driver, logger);
		boolean val = lp.invalidLogin(projectconfig.username, "Test@123");
		logger.log(LogStatus.PASS, "invalid login successful");
		Assert.assertEquals(val, true);
		report.endTest(logger);
		report.flush();
	}

	@Test(priority = 3)
	public void verifyValidLogin() {
		logger = report.startTest("verifyValidLogin");
		loginPage lp = new loginPage(driver, logger);
		HomePage hp = null;
		try {
			hp = lp.validLogin(projectconfig.username, projectconfig.password);
		} catch (Exception ex) {
			System.out.println("Exception" + ex.getMessage());
			System.out.println("Line Number " + ex.getStackTrace());
		}

		logger.log(LogStatus.PASS, "Valid login successful");
		hp.verifyHomePageURL();
		hp.clickLogoutLink();
		report.endTest(logger);
		report.flush();

	}

	@AfterClass
	public void Stop() {
		closeApp();
	}
}
