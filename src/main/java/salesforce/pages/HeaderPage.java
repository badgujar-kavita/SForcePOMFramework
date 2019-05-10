package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

	private WebDriver driver;

	By linklogout = By.linkText("Logout");
	By linkname = By.xpath("//a[@id='globalHeaderNameMink']");
	By clicklinkleads = By.linkText("Leads");

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyLogoutLink() {
		if (driver.findElements(linkname).size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void clickLogoutLink() {
		if (driver.findElements(linkname).size() == 1) {
			driver.findElement(linkname).click();
			driver.findElement(linklogout).click();
		}
	}

	public void ClickLeads() {
		driver.findElement(clicklinkleads).click();

	}
}
