package inHeritance;

public class StrangerClass {

	int a;
	public StrangerClass(int a) { //constructor with the same class name.
		this.a=a;  
	}
	
	public int increement() {
		a=a+1;
		return a;
		
	}
	
	public int decreement() {
		a=a-1;
		return a;
	}
}
