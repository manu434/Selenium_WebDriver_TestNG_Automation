package testNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Window_Handling {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");

	}

	@Test
	public void test() {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/p[1]/a")).click();
		Set<String> allwindowhandle = driver.getWindowHandles();
		for (String handle : allwindowhandle) {
			System.out.println(handle);

			if (!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"))
						.sendKeys("haakgrab100@gmail.com");
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				driver.close();

			}
			// driver.switchTo().window(parentwindow);

		}
	}
}
