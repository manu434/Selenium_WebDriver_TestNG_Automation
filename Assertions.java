package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	WebDriver driver;

	@BeforeTest
	public void assertions() {
		driver = new EdgeDriver();

	}

	@Test
	public void test() {
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		String expec = "Google";
		// hard assertions
		Assert.assertEquals(title, expec, "Title does not match!");
		System.out.println("Its happening:");

		// soft assertion
		SoftAssert soft = new SoftAssert();
		String softtitle = driver.getTitle();
		String softexpec = "Googles";
		soft.assertEquals(softtitle, softexpec);
		System.out.println("its happening");
		soft.assertAll();

	}

}
