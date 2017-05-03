package gap.com.snake.gap;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import gap.com.snake.gap.pageObjects.LoginPage;

public class LoginTest {

	@Parameters({ "login-name", "password" })
	@Test
	public void loginTest(String loginName, String password) {
		// Open the login page
		WebDriverManager.getInstance().navigateToLogin();
		// Enter the values for the login
		LoginPage loginPage = new LoginPage();
		loginPage.login(loginName, password);

		// Verify that we are into the expected page
		Assert.assertTrue(WebDriverManager.getInstance().getDriver()
				.getPageSource().contains("Listing employees"));

	}

	@AfterSuite
	public void tearDown() {
		WebDriverManager.getInstance().getDriver().close();

	}
}
