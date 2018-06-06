import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1_Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        String input = reader.readLine();
        while (!"Here We Go".equals(input)) {
            String[] inputs = input.split(" ");
            int startRow = Integer.parseInt(inputs[0]);
            int startCol = Integer.parseInt(inputs[1]);
            int endRow = Integer.parseInt(inputs[2]);
            int endCol = Integer.parseInt(inputs[3]);
            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol ; col++) {
                    matrix[row][col]++;
                }
            }
            input = reader.readLine();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
