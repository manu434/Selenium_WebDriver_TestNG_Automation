package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepicker_Enabled {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Datepicker.html");
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).sendKeys("12/04/2022");
	}

}
