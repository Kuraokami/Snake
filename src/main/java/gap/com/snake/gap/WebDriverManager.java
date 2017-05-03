package gap.com.snake.gap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	private static WebDriverManager instance = null;

	private WebDriver driver;
	protected WebDriverManager() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static WebDriverManager getInstance() {
		if (instance == null) {
			instance = new WebDriverManager();
		}
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * This method leaves the user into the loginPage
	 */
	public void navigateToLogin(){
		driver.get("http://vacations.evercoding.com");
		
	}

	public void navigateToPublicSite() {
		navigateToLogin();
		driver.findElement(By.cssSelector("#content > p > a")).click();
		
	}
	
	
}
