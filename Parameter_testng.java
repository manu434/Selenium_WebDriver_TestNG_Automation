package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_testng {
	@Test
	@Parameters("a")
	public void testParameter(String v) {
		System.out.println(v);
	}
}