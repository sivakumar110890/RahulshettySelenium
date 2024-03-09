package javaBasics;

import org.testng.annotations.Test;

public class TernaryExample {
	@Test
	public void TernaryTestExample() {
		
		int number =11;
		
		String Result= (number % 2 ==0) ? "even":"odd"; 
		System.out.println("The Number "+number+" is : "+Result);
	}

}
