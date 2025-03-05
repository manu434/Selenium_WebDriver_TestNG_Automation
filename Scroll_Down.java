package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll_Down {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void test() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		// js.executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[5]/ul/li[2]/a")));
		// js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[5]/ul/li[2]/a")).click();

	}
}

//📌 When to Use What?
//For simple up/down scrolling: ✅ scrollBy(x, y)
//For scrolling to top/bottom: ✅ scrollTo(x, y)
//For scrolling to an element: ✅ scrollIntoView()
