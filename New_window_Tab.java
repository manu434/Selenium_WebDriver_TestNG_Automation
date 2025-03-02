package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New_window_Tab {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
	}

	@Test
	public void test() {
		// WebDriver driver1 = driver.switchTo().newWindow(WindowType.TAB);
		// WebDriver driver2 = driver.switchTo().newWindow(WindowType.WINDOW);
		// driver.close();

	}

}
