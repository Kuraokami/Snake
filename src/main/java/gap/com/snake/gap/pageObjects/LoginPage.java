package gap.com.snake.gap.pageObjects;

import gap.com.snake.gap.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	private WebElement emailField;
	private WebElement passwordField;
	private WebElement signInButton;
	private WebDriver driver;

	public LoginPage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (driver.findElements(By.id("user_email")).size() <= 1){
			emailField = driver.findElement(By.id("user_email"));
			passwordField = driver.findElement(By.id("user_password"));
			signInButton = driver.findElement(By.name("commit"));
		}else {
			throw new RuntimeException("Wrong page, we are not into the login page");
		}
	}
	/**
	 * This method logins into the application
	 * @param user
	 * @param pass
	 */
	public void login (String user, String pass){
		emailField.sendKeys(user);
		passwordField.sendKeys(pass);
		// Press the Sign In Button
		signInButton.click();
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public void setSignInButton(WebElement signInButton) {
		this.signInButton = signInButton;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}

}
