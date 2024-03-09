package javaBasics;

public class MethodDemo {

	public static void main (String[] args){

		//MethodDemo m = new MethodDemo();  // object creation using the class
		//m.getData(); // calling the method 

		//String variable1=	m.getOutput();
		//	System.out.println(variable1);

		String output=finalOutput();
		System.out.println(output);
		
		methodDemo2 m2 = new methodDemo2();  // creating the object from another class
		m2.getMethod2(); // calling the method from the class methodDemo2 outside of this class
	}

	public void getData() {
		System.out.println("This is get Data Method");

	}

	public String getOutput() {
		//System.out.println("This is get Output method");
		return "This is get Output method";
	}

	public static String finalOutput() {  // static keyword will allow from your class you can call this method 
		return "This is the FinalOuput Method";
	}
}

