package gap.com.snake.gap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import gap.com.snake.gap.pageObjects.CreatePage;
import gap.com.snake.gap.pageObjects.LoginPage;

public class CreateTest {

	private WebDriver driver;

	@Parameters({ "login-name", "password", "employee_first_name",
			"employee_last_name", "employee_email", "employee_identification",
			"employee_leader_name", "employee_start_working_on" })
	@Test
	public void createTest(String loginName, String password, String firstName,
			String lastName, String email, String id, String leaderName,
			String startDate) {
		// Open the login page
		WebDriverManager.getInstance().navigateToLogin();
		// Enter the values for the login
		LoginPage page = new LoginPage();
		page.login(loginName, password);
		
		//getInto the CreatePage
		driver = WebDriverManager.getInstance().getDriver();
		driver.findElements(By.cssSelector("p a")).get(0).click();
		//create the user
		
		CreatePage creator = new CreatePage();
		creator.createEmployee(firstName, lastName, email, id, leaderName, startDate);
		//go back into the listingpage
		driver.findElements(By.cssSelector("#menu li")).get(0).click();
		//verify user into list
		List<WebElement> employees = driver.findElements(By.cssSelector("#content tbody tr"));
		Assert.assertTrue(employees.size() == 2);
		
	}

	@AfterSuite
	public void tearDown() {
		WebDriverManager.getInstance().getDriver().close();

	}
}
