import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1_FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(", ");
        int size = Integer.parseInt(inputs[0]);
        String type = inputs[1];
        if (type.equals("A")) {
            printMatrixTypeA(size);
        } else {
            printMatrixTypeB(size);
        }
    }

    private static void printMatrixTypeB(int size) {
        int[][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size ; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrixTypeA(int size) {
        int[][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size ; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
