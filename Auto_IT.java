package testNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auto_IT {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_excel");
	}

	@Test
	public void test() throws IOException {
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		Runtime.getRuntime().exec("D:\\abw.exe");
		// "D:\abw.exe"

	}

}
