package gap.com.snake.gap.pageObjects;

import gap.com.snake.gap.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListEmployeePage {

	private WebDriver driver;

	public ListEmployeePage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (!(driver.findElements(By.cssSelector("#content tbody tr")).size() >= 1)) {
			throw new RuntimeException("Wrong page, we are not into the login page");
		}
		// This page contains a list, it is likely to be our page
	}

	/**
	 * This method returns a WebElement containing the Employee ID in the list
	 * of Employees, or Null if nothing was found
	 * 
	 * @param employeeId
	 * @return
	 */
	public WebElement findEmployee(String employeeId) {
		WebElement result = null;

		// This is the list of elements inside the table
		List<WebElement> employees = driver.findElements(By.cssSelector("#content tbody tr"));

		// If the list is only one, it is the header and it is a trap
		if (employees.size() > 1) {
			f: for (int i = 1; i <= employees.size(); i++) {
				List<WebElement> employeeParts = employees.get(i).findElements(By.cssSelector("td"));
				// Get employee ID and match to param
				if (employeeParts.get(2).getText().equalsIgnoreCase(employeeId)) {
					result = employees.get(i);
					break f; // No need to continue iterating
				}
			}
		}

		return result;
	}

	/**
	 * This method tries to delete a user from the company page, if the employee
	 * does not exist, this method does nothing
	 * 
	 * @param employeeId
	 */
	public void deleteEmployee(String employeeId) {
		WebElement employee = findEmployee(employeeId);
		if (employee != null) {
			// Click the delete button
			employee.findElements(By.cssSelector("td")).get(8).findElement(By.cssSelector("a")).click();
			// Accept the alert
			driver.switchTo().alert().accept();
		}
	}

}
