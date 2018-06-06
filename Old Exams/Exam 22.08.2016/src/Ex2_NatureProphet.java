import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2_NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!"Bloom Bloom Plow".equals(input)) {
            String[] inputs = input.split(" ");
            int flowerRow = Integer.parseInt(inputs[0]);
            int flowerCol = Integer.parseInt(inputs[1]);
            for (int row = 0; row < rows; row++) {
                matrix[row][flowerCol]++;
            }
            for (int col = 0; col < cols; col++) {
                matrix[flowerRow][col]++;
            }
            matrix[flowerRow][flowerCol]--;
            input = reader.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
