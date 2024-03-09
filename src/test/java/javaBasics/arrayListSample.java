package javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayListSample {
	public static void main(String[] args) {
		// Array list is used for dynamic value declaring and it has the feature to add & to check contains 

		ArrayList<String> a = new ArrayList<String>();
		a.add("sivakumar\n");
		a.add("is the");
		a.add("smart Boy\n");


		System.out.println(a.get(0)+a.get(1)+a.get(2));

		for(  String outvalue:a) {
			System.out.println("The arraylist in enhanced for loop is : "+outvalue);

		}
		System.out.println("===========");
		for (int p=0; p<a.size();p++) {
			System.out.println("The  array list in normal for loop is : "+a.get(p));
		}
		
		// To check whether particular value is present in array List or not 
		
		System.out.println("This array contains \"is the\"value or not : "+a.contains("is the")); // This will print  Boolean value 
	
		
		// Converting normal array into arraylist
		
		String[] array = {"apple", "banana", "orange"};  // This is a normal array 
		List<String> arraString=Arrays.asList(array); // converting normal array into Array list
		System.out.println("Array contains Apple : "+arraString.contains("apple"));
		
		
		
		int [] array1 =  {1,2,3,4,5};
		List<int[]> array1Out=Arrays.asList(array1);
		array1Out.contains(3);
		
	}
	
	
	
	
	

}
