import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex13_BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blurAmount = Integer.parseInt(reader.readLine());
        String[] inputs = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(inputs[0]);
        int cols = Integer.parseInt(inputs[1]);
        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = nums[col];
            }
        }
        inputs = reader.readLine().split("\\s+");
        int row = Integer.parseInt(inputs[0]);
        int col = Integer.parseInt(inputs[1]);
        blurMatrix(matrix, row, col, blurAmount);
        printMatrix(matrix);
    }

    private static void printMatrix(long[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void blurMatrix(long[][] matrix, int row, int col, int blurAmount) {
        matrix[row][col] += blurAmount;
        if (isInside(matrix, row, col + 1)) {
            matrix[row][col + 1] += blurAmount;
        }
        if (isInside(matrix, row + 1, col + 1)) {
            matrix[row + 1][col + 1] += blurAmount;
        }
        if (isInside(matrix, row + 1, col)) {
            matrix[row + 1][col] += blurAmount;
        }
        if (isInside(matrix, row + 1, col - 1)) {
            matrix[row + 1][col - 1] += blurAmount;
        }
        if (isInside(matrix, row, col - 1)) {
            matrix[row][col - 1] += blurAmount;
        }
        if (isInside(matrix, row - 1, col - 1)) {
            matrix[row - 1][col - 1] += blurAmount;
        }
        if (isInside(matrix, row - 1, col)) {
            matrix[row - 1][col] += blurAmount;
        }
        if (isInside(matrix, row - 1, col + 1)) {
            matrix[row - 1][col + 1] += blurAmount;
        }
    }

    private static boolean isInside(long[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
