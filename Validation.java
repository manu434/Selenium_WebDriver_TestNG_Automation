package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@Test
	public void test() {
		Boolean logo = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table[1]/tbody/tr[1]/td[1]/img"))
				.isDisplayed();
		// System.out.println(logo);
		if (logo.booleanValue()) {
			System.out.println("Logo Displayed");
		} else {
			System.out.println("Logo Not Displayed");
		}
		Boolean checkbox = driver
				.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input"))
				.isSelected();
		if (checkbox.booleanValue()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("Checkbox is not selected");
		}

		Boolean selected = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]"))
				.isEnabled();
		if (selected.booleanValue()) {
			System.out.println("Male is enabled by Default");
		} else {
			System.out.println("Not Enabled");
		}
	}

}
