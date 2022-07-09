package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	// create globally to avoid again and again declaration
	protected WebDriver driver;
	protected Properties pro;

	@SuppressWarnings("deprecation")
	public WebDriver intializeDriver() throws IOException {

		pro = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\qasim.ahmed\\Desktop\\Programming\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
				//remove hard code
				
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
				
				pro.load(fis);
		//mvn testDbrowser=chrome;
		//String browserName = System.getProperty("browser");
		String browserName = pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			//Headless chrome browser
			
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("headless");
			//driver = new ChromeDriver(options);
			driver = new ChromeDriver();

		}

		if (browserName == "Firefox") {
			System.setProperty("webdriver.chrome.driver", "C:/Users/qasim.ahmed/Desktop/qas/chromedriver.exe");
			driver = new FirefoxDriver();

		}

		// apply Globally to all test casess
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException

	{
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("C:\\Users\\qasim.ahmed\\Desktop\\Programming\\E2EProject")+"\\reports\\"+testMethodName+".png";
		
		FileUtils.copyFile(src, new File(destinationFile));
		
		return destinationFile;
		
		
		//FileUtils.copyFile(src, new File("C://Users//qasim.ahmed//Desktop//File1.png"));

	}

}
