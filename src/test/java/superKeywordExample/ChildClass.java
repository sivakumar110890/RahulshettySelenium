package superKeywordExample;

public class ChildClass extends ParentClass {

	String variable = "ChildClass Variable";

	public ChildClass() {
		super();
		System.out.println("=============================================");
		System.out.println(" This is the child class constructor ");
		System.out.println("=============================================");
	}

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.getName();
		cc.getData();
	}

	public void getName() {
		System.out.println("===================================");
		System.out.println("Without super keyword the value is taken from the child class : " + variable);
		System.out.println("While using the super keyword the value is taken from the super class : " + super.variable);
		System.out.println("===================================");
	}

	public void getData() {
		super.getData(); // This super key word is overriding to the parent class "getData" method.
		System.out.println("This is getData method from childclass");
	}
}
