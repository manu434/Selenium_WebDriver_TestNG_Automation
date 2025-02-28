package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actionpgm {
	WebDriver driver;

	@BeforeTest
	public void before() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void method() {
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@Test
	public void test() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		element.sendKeys("manu");

		WebElement action = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));

		Actions act = new Actions(driver);
		act.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(element, Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(action, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).click();

	}

	@AfterTest
	public void after() {
		driver.quit();

	}

}
