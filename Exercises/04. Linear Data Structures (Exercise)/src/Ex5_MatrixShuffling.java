import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex5_MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int rows = Integer.parseInt(inputs[0]);
        int cols = Integer.parseInt(inputs[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            inputs = reader.readLine().split("\\s+");
            System.arraycopy(inputs, 0, matrix[row], 0, cols);
        }
        String input = reader.readLine();
        while (!input.equals("END")){
            if (!input.matches("swap [0-9]+ [0-9]+ [0-9]+ [0-9]+")) {
                System.out.println("Invalid input!");
                input = reader.readLine();
                continue;
            }
            inputs = input.split("\\s+");
            int ax = Integer.parseInt(inputs[1]);
            int ay = Integer.parseInt(inputs[2]);
            int bx = Integer.parseInt(inputs[3]);
            int by = Integer.parseInt(inputs[4]);
            if (!isInBounds(matrix, ax, ay) || !isInBounds(matrix, bx, by)) {
                System.out.println("Invalid input!");
                input = reader.readLine();
                continue;
            }
            String temp = matrix[ax][ay];
            matrix[ax][ay] = matrix[bx][by];
            matrix[bx][by] = temp;
            printMatrix(matrix);
            input = reader.readLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
