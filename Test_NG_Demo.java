package testNG;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_NG_Demo {
	EdgeDriver driver;
	String baseurl = "https://www.google.com/";

	@BeforeTest
	public void before() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);

	}

	@BeforeMethod
	public void method() {
		System.out.println("url refresh:");
	}

	@Test(priority = 2)
	public void test1() {
		System.out.println("test=1");
	}

	@Test(priority = 3, invocationCount = 3, enabled = false)
	public void test2() {
		System.out.println("test-2");
	}

	@Test(priority = 1, dependsOnMethods = { "test1" })
	public void test3() {
		System.out.println("test-3");
	}

	@AfterMethod
	public void amethod() {
		System.out.println("report generation");
	}

	@AfterTest
	public void atest() {
		driver.quit();
	}
}
