package javaBasics;

public class YesNoCombinations {

    public static void generateCombinations(int n, String[] currentCombination) {
        if (n == currentCombination.length) {
            for (String value : currentCombination) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            currentCombination[n] = "Yes";
            generateCombinations(n + 1, currentCombination);

            currentCombination[n] = "No";
            generateCombinations(n + 1, currentCombination);
        }
    }

    public static void main(String[] args) {
        int gridSize = 5;
        String[] initialCombination = new String[gridSize];
        generateCombinations(0, initialCombination);
    }
}
