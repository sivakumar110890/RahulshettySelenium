package inHeritance;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParentClass {

	@BeforeTest
	public void beforeTestMethodInParent() {
		System.out.println("This method beforeTestMethodInParent is exist in ParentClass ");
	}
	public void FirstMethodinParentClass() {
		System.out.println("This is the First Method in Parent Class");
	}
	

}
