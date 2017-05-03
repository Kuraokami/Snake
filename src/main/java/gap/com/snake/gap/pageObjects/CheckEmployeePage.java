package gap.com.snake.gap.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gap.com.snake.gap.WebDriverManager;

public class CheckEmployeePage {

	private WebElement identificationField;

	private WebElement commitButton;
	private WebDriver driver;

	public CheckEmployeePage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (driver.findElements(By.id("employee_identification")).size() == 1) {
			identificationField = driver.findElement(By.id("employee_identification"));

			commitButton = driver.findElement(By.name("commit"));
		} else {
			throw new RuntimeException("Wrong page, we are not into the Check Employee page");
		}
	}

	/**
	 * This method looks for the employee and returns an empty string if nothing
	 * is found or the employee name, indicating that the value exists.
	 * 
	 * @param employeeId
	 * @return
	 */
	public String checkEmployee(String employeeId) {
		String result = "";
		identificationField.sendKeys(employeeId);
		commitButton.click();
		String verification = driver.findElement(By.cssSelector("#content h1")).getText();
		if (!verification.toLowerCase().contains("No Employee found with that identification")) {
			result = verification.substring(2, verification.length());
		}
		return result;
	}

	public WebElement getIdentificationField() {
		return identificationField;
	}

	public WebElement getCommitButton() {
		return commitButton;
	}

}
