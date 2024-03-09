package inHeritance;

import org.testng.annotations.Test;

public class StrangerClass2 {

	@Test
	public void operation() {

		StrangerClass sc = new StrangerClass(3); // New object creation and calling the parameterized constructor
		//int a;
		System.out.println("Increement value :" + sc.increement());
		System.out.println("Decreement value :" + sc.decreement());

	}

}
