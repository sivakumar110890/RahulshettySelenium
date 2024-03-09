package testNGExamples;

import org.testng.annotations.Test;

public class Testing {
	
	@Test(priority = 2)
	public static void test() {
		System.out.println("This is the demo of the TESTNG priority 2");
	}

	@Test(priority = 1)
	public static void test1() {
		System.out.println("This is the demo of the TESTNG priority 1");
	}
}
