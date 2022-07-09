package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPageFactory;
import pageObjects.LoginPageFactory;
import resources.base;

public class homePage extends base {
	
	WebDriver driver;
	private static Logger log = LogManager.getLogger(homePage.class.getName());

	@BeforeTest
	public void wakeUp() throws IOException {
		driver = intializeDriver();
		driver.get(pro.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String userPassword, String UserText) throws IOException {

		LandingPageFactory landingPage = new LandingPageFactory(driver);
		landingPage.getLogin().click();

		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(userPassword);
		loginPage.loginButton().click();
		//System.out.println(UserText);
		log.info(UserText);

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][3];
		data[0][0] = "Test1@gmail.com";
		data[0][1] = "1234";
		data[0][2] = "restrictedUser";

		/*
		 * data[1][0] = "Test2@gmail.com"; data[1][1] = "4567"; data[1][2] =
		 * "unRestrictedUser";
		 */

		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
