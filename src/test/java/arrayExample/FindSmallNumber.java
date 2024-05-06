package arrayExample;

public class FindSmallNumber {

	public static void main(String[] args) {
		int[][] array1 = { { 9, 6, 3 }, { 8, 6, 2 }, { 1, 2, 3 } };
		FindSmallNumber fi = new FindSmallNumber();

		int minimumvalue = fi.findSmallNu(array1);
		System.out.println("The min : " + minimumvalue);
	}

	public int findSmallNu(int[][] array) {

		int min = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {

				// System.out.print(array[i][j]);
				if (array[i][j] < min) {
					min = array[i][j];
				}
			}

		}

		return min;
	}

}
