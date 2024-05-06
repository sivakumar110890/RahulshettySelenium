package inheritanceExample;

public class ChildClass extends ParentClass{

	public static void main(String[] args) {
		
		ChildClass ch = new ChildClass();
		ch.Brakes();
		ch.Engine();
		ch.audiosystem();
		//colorofChildmethod();
	}
	
	public static void colorofChildmethod() {
		System.out.println(colorOfParentClass); // This 
	}

	public void audiosystem() { // method overriding , here method name is same in parent as well as child class. So method is overriding happened.
		System.out.println(" This Audiosystem method is from the child class");
	}
}
