import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex3_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            int[] inputs = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(inputs, 0, matrix[row], 0, size);
        }
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < size; i++) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[i][size - i - 1];
        }
        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }
}
