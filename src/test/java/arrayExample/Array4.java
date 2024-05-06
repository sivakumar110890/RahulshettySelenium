package arrayExample;

public class Array4 {

	public static void main(String[] args) {

		int array[] = new int[4]; // When we are not defining any value to the array. The default value will be
									// "0"
		for (int s = 0; s < array.length; s++) {
			System.out.println("Default value of arrays: " + array[s]);
		}
		
		array[1]=5; // we are replacing the array index 1 with the value of 5
		for (int s = 0; s < array.length; s++) {
			System.out.println("Array index 1 value : " + array[s]);
		}
		
		int array4[] = new int[4];
		array4[0]=0; // traditional method to declare the array values
		array4[1]=1;
		array4[2]=2;
		array4[3]=3;
		
		for(int a:array4) { // for each loop to get the data
			System.out.println("Final : "+a);
		}
	}

}
