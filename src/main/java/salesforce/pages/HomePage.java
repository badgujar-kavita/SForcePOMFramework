package salesforce.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends HeaderPage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifyHomePageURL() {
		if (driver.getCurrentUrl().equals(
				"https://qalightening-devorg-dev-ed.my.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom")) {
			return true;
		} else {
			return false;
		}
	}

}
