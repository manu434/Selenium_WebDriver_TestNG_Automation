package testNG;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	WebDriver driver;
	String baseurl = "https://www.facebook.com/";
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;

	@BeforeTest
	public void bt() {
		reporter = new ExtentSparkReporter("./Extent/extentreport.html");
		reporter.config().setDocumentTitle("Automation_Report");
		reporter.config().setReportName("My First Extent Report");
		// reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Browser", "Microsoft Edge");
		extent.setSystemInfo("Version", "5.5");
		extent.setSystemInfo("Tester_name", "Manu K Shibu");
		extent.setSystemInfo("OS", "Windows_11");

		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void beforemethod() {
		driver.manage().window().maximize();
		driver.get(baseurl);
	}

	@Test
	public void facebooktitleverification() throws IOException {
		test = extent.createTest("FB Title Verification");
		String expected = "Facebook – log in or sign up";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
		System.out.println("hello");

	}

	@Test
	public void fbbuttontest() {
		test = extent.createTest("fb button test");
		String buttontext = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).getText();
		Assert.assertEquals(buttontext, "Faccebook");

	}

	@Test
	public void fblogotest() {
		test = extent.createTest("Logo test");
		Boolean logo = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).isDisplayed();
		Assert.assertTrue(logo);

	}

	@AfterMethod
	public void browserclose(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "test case failed is" + result.getName());
			test.log(Status.FAIL, "test case failed is" + result.getThrowable());
			String screenshotpath = Extent_Report.screenshotmethod(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "test is skipped" + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "test result is passed" + result.getName());

		}

	}

	private static String screenshotmethod(WebDriver driver, String screenshotname) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = "./screenshot/" + screenshotname + ".png";
		FileHandler.copy(src, new File(destination));

		return destination;
	}

	@AfterTest
	public void teardown() {
		extent.flush();
	}

}
