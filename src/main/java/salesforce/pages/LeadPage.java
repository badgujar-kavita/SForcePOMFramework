package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class LeadPage {

	private WebDriver driver;
	private ExtentTest logger;

	public LeadPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	By newbtn = By.xpath("//input[@name='new']");
	By txtfirstname = By.id("name_firstlea2");
	By txtlastname = By.id("name_lastlea2");
	By txtcompanyname = By.id("lea3");
	By savebtn = By.xpath("//input[@name='save']");
	By lightnpopup = By.xpath("//a[@id='tryLexDialogX']");

	public void CreateLead(String firstname, String lastname, String company) {

		driver.findElement(lightnpopup).click();
		driver.findElement(newbtn).click();
		driver.findElement(txtfirstname).sendKeys(firstname);
		driver.findElement(txtlastname).sendKeys(lastname);
		driver.findElement(txtcompanyname).sendKeys(company);
		driver.findElements(savebtn).get(0).click();

	}

}
