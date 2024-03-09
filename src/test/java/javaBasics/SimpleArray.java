package javaBasics;

import org.testng.annotations.Test;

public class SimpleArray {

	@Test
public static void arrayExample() {
	int[] numbers = {11,18,21};
	for (int output:numbers) {
		System.out.println("Output is : "+output);
	}
}
}
