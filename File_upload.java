package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class File_upload {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");

	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id='uploadfile_0']")).sendKeys("D:\\day10 selenium.pdf");
		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();
		// WebElement a= driver.findElement(By.xpath("//*[@id=\"res\"]/center"));

	}

}
