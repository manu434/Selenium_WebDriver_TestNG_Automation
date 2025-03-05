package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepicker_Disabled {
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
		driver.findElement(By.xpath("//*[@id=\"datepicker1\"]")).click();
		while (true) {
			WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div"));
			String month1 = month.getText();
			if (month1.equals("April 2025")) {
				System.out.println(month1);
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}

		}
		List<WebElement> alldays = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		for (WebElement date : alldays) {
			String day = date.getText();
			if (day.equals("8")) {
				date.click();
				break;
			}
		}

	}
}
