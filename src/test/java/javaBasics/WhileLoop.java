package javaBasics;

public class WhileLoop {

	public static void main(String[] args) {
		DoWhileExample();
	}

	public static void WhileLoopExample() {

		int i = 0;

		while (i <= 10) // while(boolean) means the condition is true or false
		// In while loop first it checks the condition then it's incrementally
		// adding/decresing the value
		{
			System.out.println(i);
			i++;
		}
	}
	
	public static void DoWhileExample() {
		
		int j=20;
		do { // In do while first it increement/decreement then it starts verifying the condition
			System.out.println("Before Incrementing : "+j);
			j++;
			System.out.println("After Incrementing : "+j);
			System.out.println("==========================");
		}
		while(j<30); // Minimum one loop is guarantee even for any condition
			
			
	}
}
