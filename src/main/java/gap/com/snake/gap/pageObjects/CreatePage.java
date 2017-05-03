package gap.com.snake.gap.pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gap.com.snake.gap.WebDriverManager;

public class CreatePage {

	private WebElement firstNameField;
	private WebElement lastNameField;
	private WebElement emailField;
	private WebElement identificationField;
	private WebElement leaderNameField;
	private Select dayField;
	private Select monthField;
	private Select yearField;

	private WebElement commitButton;
	private WebDriver driver;

	public CreatePage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (driver.findElements(By.id("employee_email")).size() == 1) {
			firstNameField = driver.findElement(By.id("employee_first_name"));
			lastNameField = driver.findElement(By.id("employee_last_name"));
			emailField = driver.findElement(By.id("employee_email"));
			identificationField = driver.findElement(By.id("employee_identification"));
			leaderNameField = driver.findElement(By.id("employee_leader_name"));

			yearField = new Select(driver.findElement(By.id("employee_start_working_on_1i")));
			monthField = new Select(driver.findElement(By.id("employee_start_working_on_2i")));
			dayField = new Select(driver.findElement(By.id("employee_start_working_on_3i")));

			commitButton = driver.findElement(By.name("commit"));
		} else {
			throw new RuntimeException("Wrong page, we are not into the Create page");
		}
	}

	public void createEmployee(String firstName, String lastName, String email, String id, String leaderName,
			String date) {
		try {

			firstNameField.sendKeys(firstName);
			lastNameField.sendKeys(lastName);
			emailField.sendKeys(email);
			identificationField.sendKeys(id);
			leaderNameField.sendKeys(leaderName);

			SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(date));

			dayField.selectByValue(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			monthField.selectByIndex(cal.get(Calendar.MONTH));
			yearField.selectByValue(String.valueOf(cal.get(Calendar.YEAR)));

			commitButton.click();

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getIdentificationField() {
		return identificationField;
	}

	public WebElement getLeaderNameField() {
		return leaderNameField;
	}

	public Select getDayField() {
		return dayField;
	}

	public Select getMonthField() {
		return monthField;
	}

	public Select getYearField() {
		return yearField;
	}

	public WebElement getCommitButton() {
		return commitButton;
	}

}
