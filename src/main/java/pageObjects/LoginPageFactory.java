package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		// local driver = driver form Login page
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='user_email']")
	WebElement emailAddress;

	public WebElement getEmail() {

		return emailAddress;
	}
	
	@FindBy(css = "input[id='user_password']")
	WebElement password;

	public WebElement getPassword() {

		return password;
	}

	@FindBy(name ="commit")
	WebElement loginButton;

	public WebElement loginButton() {

		return loginButton;
	}
	
	
}
