package javaBasics;

public class ifElseConditionSample {
	public static void main(String[] args) {

		int[] array1 = {1,2,22,33,44,55,100};

		for (int u=0; u<array1.length; u++) {
			if (array1[u] % 2 ==0) {
				System.out.println("The value of Even number is : "+array1[u]);
				break; // break here is used to end the loop after satisfying the first condition
			}
			else {
				System.out.println("The value of Odd number is : "+array1[u]);
			}
		}
	}

}
