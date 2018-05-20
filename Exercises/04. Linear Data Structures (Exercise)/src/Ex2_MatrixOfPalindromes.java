import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2_MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(inputs[0]);
        int cols = Integer.parseInt(inputs[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf((char)('a' + row))
                        + String.valueOf((char)('a' + row + col))
                        + String.valueOf((char)('a' + row));
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
