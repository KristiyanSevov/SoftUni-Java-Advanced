import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex4_MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int rows = Integer.parseInt(inputs[0]);
        int cols = Integer.parseInt(inputs[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(nums, 0, matrix[row], 0, cols);
        }
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        sum += matrix[i][j];
                    }
                }
                if (sum > bestSum) {
                    bestSum = sum;
                    bestCol = col;
                    bestRow = row;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        for (int i = bestRow; i < bestRow + 3; i++) {
            for (int j = bestCol; j < bestCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
