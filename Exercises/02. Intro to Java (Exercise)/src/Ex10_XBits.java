import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10_XBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[8][32];
        for (int row = 0; row < 8; row++) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(reader.readLine()));
            int counter = 31;
            for (int i = binaryString.length() - 1; i >= 0; i--) {
                matrix[row][counter] = binaryString.charAt(i) - '0';
                counter--;
            }
        }
        int countPatterns = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                if (matrix[row][col] == 1 && matrix[row][col + 1] == 0 && matrix[row][col + 2] == 1 &&
                        matrix[row + 1][col] == 0 && matrix[row + 1][col + 1] == 1 && matrix[row + 1][col + 2] == 0 &&
                        matrix[row + 2][col] == 1 && matrix[row + 2][col + 1] == 0 && matrix[row + 2][col + 2] == 1) {
                    countPatterns++;
                }
            }
        }
        System.out.println(countPatterns);
    }
}
