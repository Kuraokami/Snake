package gap.com.snake.gap;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import gap.com.snake.gap.pageObjects.CheckEmployeePage;

public class VerifyTest {


	@Parameters({ "employee_identification" })
	@Test
	public void verifyTest(String id) {
		// Open the public page
		WebDriverManager.getInstance().navigateToPublicSite();

		// search for the employee
		CheckEmployeePage checkPage = new CheckEmployeePage();

		String employeeName = checkPage.checkEmployee(id);
		// verify employee data
		Assert.assertTrue(employeeName.toLowerCase().contains("james smith"));

	}

	@AfterSuite
	public void tearDown() {
		WebDriverManager.getInstance().getDriver().close();

	}
}
