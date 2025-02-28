package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag_Drop {
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void beforemethod() {
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
	}

	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		String drop1 = drop.getText();
		System.out.println(drop1);
		if (drop1.equals("Dropped!")) {
			System.out.println("success");
		} else {
			System.out.println("not expected");
		}
	}

	@AfterTest
	public void complete() {
		driver.quit();
	}

}
