package testNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Robot_Class_File_Upload {
	WebDriver driver;

	@BeforeTest
	public void bt() {
		driver = new EdgeDriver();
	}

	@BeforeMethod
	public void bm() {
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_excel");

	}

	@Test
	public void test() throws AWTException {
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		fileUpoad("D:\\day10 selenium.pdf");

	}

	public void fileUpoad(String p) throws AWTException {

		StringSelection strselection = new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		Robot robot = new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
