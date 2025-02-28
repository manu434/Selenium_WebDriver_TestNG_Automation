package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_hover {
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void beforemethod() {
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}

	@Test
	public void test() {
		// implicit wait(global wait)
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement action = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(action).perform();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Smartphones and accessories']"))).click();

	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
