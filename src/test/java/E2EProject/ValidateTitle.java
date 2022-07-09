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

public class ValidateTitle extends base {
	WebDriver driver;
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	LandingPageFactory landingPage;

	@BeforeTest
	public void wakeUp() throws IOException {
		driver = intializeDriver();
		log.info("Driver is intiallize");
		driver.get(pro.getProperty("url"));
		log.info("Navigate to URL Successfully");
	}

	@Test
	public void basePageNavigation() throws IOException {

		landingPage = new LandingPageFactory(driver);

		// Happy path
		Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Title FEATURED COURSES");

		// wrong input just to know error
		// Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES123");
		// log.info("Successfully validated Title FEATURED COURSES");

	}

	@Test
	public void getAcademyTitle() throws IOException {

		// Happy path
		Assert.assertEquals(landingPage.tagNameAcademy().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated Title An Academy to learn Everything about Testing'");

		// wrong input just to know error
		// Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES123");
		// log.info("Successfully validated Title FEATURED COURSES");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
