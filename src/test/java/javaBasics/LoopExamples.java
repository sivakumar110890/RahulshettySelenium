package javaBasics;

public class LoopExamples {

	public static void main(String[] args) {
		// PrintPyramidTriangle();
		// PrintPyramidinreverse();
		sortLoop();
	}

	public static void PrintPyramidTriangle() {
		System.out.println("======= Print pyramid ==========");
		int k = 1;
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4 - i; j++) {
				System.out.print(k + "\t"); // This \t gives the tab space in between two outputs
				k++;
			}
			System.out.println(""); // This statement makesure next output prints on next line
		}

	}

	public static void PrintPyramidinreverse() {
		System.out.println("======= Print reverse pyramid ==========");
		int k = 1;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k + "\t");
				k++;
			}
			System.out.println("");
		}
		System.out.println("=================");
	}

	public static void sortLoop() {

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {

				System.out.print(j + "\t");

			}
			System.out.println("");
		}
	}

}
