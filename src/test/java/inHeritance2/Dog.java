package inHeritance2;

public class Dog extends Animal {
	
	public Dog() {
		super(); // This will call the parent call method (Animal) 
		System.out.println("Constructor of Dog class");
	}
	
	public static void main(String[] args) {
		Dog MyDog = new Dog();

	}

	
}
