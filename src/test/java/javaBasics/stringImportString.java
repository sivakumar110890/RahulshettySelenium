package javaBasics;

public class stringImportString {

	public static void main (String [] args) {

		// String is an object
		// String can be declared in two ways 1) literal & 2) by mentioning new() keyword ;

		// Literal String method declaration;
		String s = "sivakumar is the coolest person ";
		String s1="sivakumar is the coolest person "; // When there is multiple string value is same as another then java
		// java stores in same memory and point to another object 
		// here "sivakumar is the coolest person "; same string so it stores in s and s1 is pointed to the  s object;
		s.split(s);




		// String declaration using new() method

		String s2 = new String ("This string is declared using new method ");
		String s3 = new String ("This string is declared using new method "); // For the same string, it creates two memory allocation
		String[] arrayString=s2.split(" ");
		for (  String val :arrayString) {
			System.out.println(val);
		}
		System.out.println("=========================");
		String b = new String ("This is the string");
		String[] trimmed = b.split("the");
		System.out.println(trimmed[0].trim());
		System.out.println(trimmed[1].trim());

	}

}
