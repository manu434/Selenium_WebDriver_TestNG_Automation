package testNG;

import org.testng.annotations.Test;

public class Grouping {

	@Test(groups = { "smoke", "sanity" })
	public void main1() {
		System.out.println("The main-1");

	}

	@Test(groups = { "regression" })
	public void main2() {
		System.out.println("The main-2");
	}

	@Test(groups = { "smoke" })
	public void main3() {
		System.out.println("the main-3");
	}

	@Test(groups = { "Sanity", "Regression" })
	public void main4() {
		System.out.println("The main-4");
	}

	@Test(groups = { "smoke", "sanity" })
	public void main5() {
		System.out.println("The main-5");
	}

}
