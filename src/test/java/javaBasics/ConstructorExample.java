package javaBasics;

public class ConstructorExample {

	public ConstructorExample() {
		// TODO Auto-generated constructor stub
		System.out.println("This constructor does not have any parameter");
	}
	
	public ConstructorExample(String siva) {
		System.out.println("This constructor contains parameter of String ");
	}
	public ConstructorExample(int a) {
		System.out.println("This constructor is belongs to int");
	}
	public static void main(String[] args) {
		ConstructorExample ce=new ConstructorExample();
		ConstructorExample StringE=new ConstructorExample("siva");
		ConstructorExample inte=new ConstructorExample(9);
	}

}
