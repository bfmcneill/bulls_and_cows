

public class GameMatrix {

    public static String[][] processGuess(String[][] matrix,String guess, String secretCode) {
        String[] guessArr = guess.split("");
        String[] secretArr = secretCode.split("");

        int size = matrix[0].length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isCow = guessArr[i].equals(secretArr[j]);
                boolean isBull = (i==j) && isCow;
                matrix[j][i] = isCow ? (isBull ? "B" : "C") : "/";
            }
        }
        return matrix;
    }

    public static String[][] init(int size) {
        String[][] matrix = new String[size][size];

        // loop through each element in 2D array and set it to "/"
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = "/";
            }
        }
        return matrix;
    }

    public static void debug(String[][] matrix) {
        int matrixSize = matrix[0].length;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
