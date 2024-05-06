package javaBasics;

public final class FinalKeywordExample { // When we define this final keyword in a class level, we cannot inherit this
											// class in any of the subclass (child)

	public static final int a=5; // When the variable declared as a final this variable cannot be changed for its entire lifetime.
	public FinalKeywordExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		System.out.println("The Value of the 'a' is :"+a);
	}

}
