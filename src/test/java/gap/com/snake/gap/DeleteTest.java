package gap.com.snake.gap;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import gap.com.snake.gap.pageObjects.CreatePage;
import gap.com.snake.gap.pageObjects.ListEmployeePage;
import gap.com.snake.gap.pageObjects.LoginPage;

public class DeleteTest {

	private WebDriver driver;

	@Parameters({ "login-name", "password", "employee_identification" })
	@Test
	public void deleteTest(String loginName, String password, String id) {
		// Open the login page
		WebDriverManager.getInstance().navigateToLogin();
		// Enter the values for the login
		LoginPage page = new LoginPage();
		page.login(loginName, password);

		// get the List page
		ListEmployeePage employeeListPage = new ListEmployeePage();
		
		// Find the user with ID passed as param
		WebElement employee = employeeListPage.findEmployee(id);
		// if exists, delete, else fail, as the test deletes a user that exists
		if (employee == null){
			Assert.fail(MessageFormat.format("Employee with ID {0} does not exist, Exiting.", id));
		} else {
			employeeListPage.deleteEmployee(id);
		}
		
		// Find the user with ID passed as param
		WebElement nullEmployee = employeeListPage.findEmployee(id);
		// verify that it does not exists anymore
		Assert.assertNull(nullEmployee);
	}

	@AfterSuite
	public void tearDown() {
		WebDriverManager.getInstance().getDriver().close();

	}
}
