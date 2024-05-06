package arrayExample;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		multidimensionalarray();
	}

	public static void multidimensionalarray() {

		int arrayb[][] = { { 4, 5, 6 }, { 7, 8, 9 } };

		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 3; y++) {
				System.out.print(arrayb[x][y]+"\t");
			}
			
		}

	}

	public void multidimExample2() {
		int arr[][] = new int[2][3];

		// 1 2 3
		// 4 5 6
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;

		// System.out.println(arr[1][2]);

		for (int i = 0; i <= 1; i++) {

			for (int j = 0; j < 3; j++) {
				System.out.println(arr[i][j]);
			}

		}
	}

}
