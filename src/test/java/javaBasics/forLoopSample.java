package javaBasics;

public class forLoopSample {
	public static void main(String[] args) {
		
		String[] name = {"sivakumar","balaji","daivik","genious","smart"};
		
		for(int k=0; k<name.length; k++) { // First loop method 
			System.out.println("The String names are : "+name[k]);
		}
		
		for(String a:name) { // Enhanced for loop 
			System.out.println("The value of Array is : "+a);
		}
	}

}
