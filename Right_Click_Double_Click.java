package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Right_Click_Double_Click {
	WebDriver driver;

	@BeforeTest
	public void beforemethod() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void beforetest() {
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

	}

	@Test
	public void test() {
		WebElement rightclick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		Actions act = new Actions(driver);
		act.contextClick(rightclick).perform();

		WebElement edit = driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]/span"));
		edit.click();
		driver.switchTo().alert().accept();

		WebElement doubleclickc = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		act.doubleClick(doubleclickc).perform();
		driver.switchTo().alert().accept();

	}

	@AfterTest
	public void aftertest() {
		driver.quit();

	}
}
