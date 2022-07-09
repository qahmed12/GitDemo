
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageFactory {

	WebDriver driver;

	public LandingPageFactory(WebDriver driver) {
		// local driver = driver form Login page
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='https://rahulshettyacademy.com/sign_in/']")
	WebElement LoginButton;

	public WebElement getLogin() {

		return LoginButton;
	}

	@FindBy(xpath = "//*[text()='Featured Courses']")
	WebElement getTitle;

	public WebElement getTitle() {

		return getTitle;
	}

	@FindBy(css ="ul[class='nav navbar-nav navbar-right']")
	WebElement navigationBar;

	public WebElement navigationBar() {

		return navigationBar;

	}
	
	
	
	

	@FindBy(xpath ="//h3[text()='An Academy to learn Everything about Testing']")
	WebElement tagNameAcademy;

	public WebElement tagNameAcademy() {

		return tagNameAcademy;
}
}
