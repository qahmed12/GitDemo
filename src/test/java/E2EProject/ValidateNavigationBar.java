package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPageFactory;
import resources.base;

public class ValidateNavigationBar extends base {
	WebDriver driver;
	
	private static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	
	@BeforeTest
	public void wakeUp() throws IOException {
		driver = intializeDriver();
		driver.get(pro.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {


		System.out.println("Added new line for testing");
		LandingPageFactory landingPage = new LandingPageFactory(driver);
		Assert.assertTrue(landingPage.navigationBar().isDisplayed());
		log.info("Successfully validated Title FEATURED COURSES");

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
