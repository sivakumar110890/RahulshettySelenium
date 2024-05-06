package javaBasics;

public class ThisKeywordExample {

	int a = 10;

	public ThisKeywordExample() {
		// TODO Auto-generated constructor stub
	}

	public void printthis() {
		int a = 5;
		System.out.println("Print the variable: " + a);
		System.out.println("Print the variable usign this keyword : " + this.a);
	}

	public static void main(String[] args) {
		ThisKeywordExample th = new ThisKeywordExample();
		th.printthis();

	}

}
