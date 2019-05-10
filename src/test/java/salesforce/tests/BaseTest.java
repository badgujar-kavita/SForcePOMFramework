package salesforce.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import salesforce.configfile.projectconfig;

public class BaseTest {
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static String extentReport;

	public void createReport() {
		report = new ExtentReports(projectconfig.reportpath);
	}

	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", projectconfig.chromepath);
		driver = new ChromeDriver();
		driver.get(projectconfig.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(projectconfig.defaulttimeout, TimeUnit.SECONDS);
	}

	public void closeApp() {
		driver.close();
		driver.quit();
	}

}
