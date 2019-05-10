package salesforce.configfile;

public class projectconfig {

	public static String url = "https://login.salesforce.com/";
	public static String username = "kavita.badgujar@lightning.com";
	public static String password = "$23EngineeR";

	public static String chromepath = System.getProperty("user.dir")
			+ "/src/main/java/salesforce/utilities/chromedriver.exe";

	public static String reportpath = System.getProperty("user.dir") + "/src/main/java/salesforce/reports/index.html";
	public static String screenshotfolder = System.getProperty("user.dir") + "/src/main/java/salesforce/reports/";
	public static long defaulttimeout = 30;

}
