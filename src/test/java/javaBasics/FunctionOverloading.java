package javaBasics;

public class FunctionOverloading {

	public static void main(String[] args) {
		FunctionOverloading f = new FunctionOverloading();
		f.FirstMethod(0);
		f.FirstMethod("Empty string");

	}

	public void FirstMethod(int a) {
		System.out.println("integer : " + a);
	}

	public void FirstMethod(String b) {
		System.out.println("String : " + b);
	}
}
