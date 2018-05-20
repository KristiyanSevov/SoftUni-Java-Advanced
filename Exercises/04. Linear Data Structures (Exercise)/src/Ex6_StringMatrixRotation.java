import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex6_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int degrees = Integer.parseInt(reader.readLine().split("[()]")[1]);
        List<String> lines = new ArrayList<>();
        int maxLength = 0;
        String input = reader.readLine();
        while (!input.equals("END")) {
            lines.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = reader.readLine();
        }
        char[][] matrix = new char[lines.size()][maxLength];
        for (int row = 0; row < matrix.length; row++) {
            String padded = String.format("%-" + maxLength + "s", lines.get(row));
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = padded.charAt(col);
            }
        }
        switch ((degrees / 90) % 4) {
            case 0:
                printMatrix(matrix);
                break;
            case 1:
                printMatrix90(matrix);
                break;
            case 2:
                printMatrix180(matrix);
                break;
            case 3:
                printMatrix270(matrix);
                break;
        }
    }

    private static void printMatrix270(char[][] matrix) {
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
