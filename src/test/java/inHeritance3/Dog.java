package inHeritance3;

public class Dog extends Animal {

	int age = 5;

	public void Display() {
		System.out.println("This method is Dog Display method");
		System.out.println("The Dog age is : " + age);
		System.out.println("The Animal age is : " + super.age);
		super.Display(); // calling the parent method (Animal Display method)
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.Display();
	}
}
