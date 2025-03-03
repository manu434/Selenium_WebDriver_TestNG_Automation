package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Data_Driven {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();

	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void test() throws IOException, InterruptedException {
		File f = new File("D:\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			String username = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(username);
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(password);
			// Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);

			driver.findElement(By.name("login")).click();
			// driver.navigate().back();
			driver.navigate().refresh();

			// Login Validation
			String actualurl = driver.getCurrentUrl();
			String expectedurl = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzQwOTk0NjgxLCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D&next";
			if (actualurl.equals(expectedurl)) {
				System.out.println("Success validation");
			} else {
				System.out.println("Login Validation Failed");
			}
		}

	}
}
