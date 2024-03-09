package javaBasics;

import java.lang.reflect.Array;

public class arraySample {
	public static void main(String [] args) {
		int[] array1 = new int[5]; // First method to declare the array (declaring the memory space)
		array1[0]=0;
		array1[1]=1;
		array1[2]=2;
		array1[3]=3;
		array1[4]=4;
		
		
		int[] array2={1,2,3,4,5,6}; // Second method to declare the array(declaring the  value)
		
		for(int i=0; i<array1.length; i++){
			System.out.println("The Value of I is :"+array1[i]);
			
		}
		
		for(int j=0; j<array2.length;j++) {
			System.out.println("The array J valus is : "+array2[j]);
		}
		
	}

}
