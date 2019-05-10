package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class loginPage {

	private WebDriver driver;
	private ExtentTest logger;

	public loginPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	By txtusername = By.id("username");
	By txtpassword = By.id("password");
	By btnLogin = By.id("Login");
	By errmsglogin = By.id("error");
	By imglogo = By.xpath("//img[@src='/img/logo214.svg']");

	public void Login(String userid, String pwd) {
		driver.findElement(txtusername).sendKeys(userid);
		driver.findElement(txtpassword).sendKeys(pwd);
		driver.findElement(btnLogin).click();

	}

	public HomePage validLogin(String userid, String pwd) {
		driver.findElement(txtusername).clear();
		logger.log(LogStatus.INFO, "Textbox cleared");
		driver.findElement(txtusername).sendKeys(userid);
		logger.log(LogStatus.PASS, userid + "entered the respective username into user textbox");
		driver.findElement(txtpassword).clear();
		logger.log(LogStatus.INFO, "Textbox cleared");
		driver.findElement(txtpassword).sendKeys(pwd);
		logger.log(LogStatus.PASS, pwd + "entered the respective password into password textbox");
		driver.findElement(btnLogin).click();
		logger.log(LogStatus.PASS, "clicked on the login button");
		return new HomePage(driver);

	}

	public boolean invalidLogin(String userid, String pwd) {
		driver.findElement(txtusername).sendKeys(userid);
		driver.findElement(txtpassword).sendKeys(pwd);
		driver.findElement(btnLogin).click();
		if (driver.findElements(errmsglogin).size() == 1) {

			return true;
		} else {
			return false;
		}
	}

	public boolean verifyLogo() {
		if (driver.findElements(imglogo).size() == 1) {

			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTitle() {
		System.out.println("driver.getTitle()---" + driver.getTitle());
		if (driver.getTitle().trim().equals("Login | Salesforce")) {
			return true;
		} else {
			return false;
		}
	}

}
