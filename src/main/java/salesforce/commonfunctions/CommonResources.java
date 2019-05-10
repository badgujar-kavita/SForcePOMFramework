package salesforce.commonfunctions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import salesforce.configfile.projectconfig;

public class CommonResources {
	public static String getscreenshot(String flname, WebDriver driver) throws IOException {
		DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		String datestr = format.format(date);
		String filename = projectconfig.screenshotfolder + flname + "_" + datestr + ".png";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// below method will save the screen shot in d drive with a name
		FileUtils.copyFile(srcFile, new File(filename));
		return filename;
	}

}
