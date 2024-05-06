package javaBasics;

public class StaticExample {

	String name; // Instance Variable
	String Address;
	static String State;
	static String Country;

	static String City = "Bangalore"; // This static variable accessed across this class
	static int a = 0; // static variable and this can be accessed across this class

	static {
		State = "Karnataka"; // Variables are initialized in a static blocks
		Country = "India";

	}

	public StaticExample(String name1, String Address1) { // Local variable only accesses within this constructor
		// TODO Auto-generated constructor stub
		this.Address = Address1; // Assigning the local variable to instance variable
		System.out.println("Address is : " + Address);
		System.out.println("This is called in Constructor : " + City); // This value is coming from the static variable
		a++;
		System.out.println(" The value of a in constructor : " + a);
	}

	public static int getAValue() {
		a++;
		System.out.println(" The value of a in 'getAValue' method : " + a);
		return a;
	}

	public static void getCity() { // Static method should use static variables only
		System.out.println("This method name is called in 'getCity' : " + City);
	}

	public static void main(String[] args) {
		StaticExample so = new StaticExample("sivakumar", "Murugan Illam");
		StaticExample so1 = new StaticExample("Chinnu", "Murugan Illam");
		StaticExample so2 = new StaticExample("Sivakumar Chinnu", "Murugan Illam");
		StaticExample.getCity(); // static methods can be called without object creation \

	}

}
