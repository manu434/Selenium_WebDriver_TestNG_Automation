package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Test {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

	}

	@Test
	public void navigateToUrl() {
		// Navigate to a URL before each test method
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
