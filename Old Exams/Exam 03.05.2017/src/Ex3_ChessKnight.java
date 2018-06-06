import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex3_ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            String input = reader.readLine();
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = input.charAt(col * 2);
            }
        }
        List<String> takenPieces = new ArrayList<>();
        int countInvalidMoves = 0;
        int countOutsideMoves = 0;

        String initialPosition = reader.readLine();
        int curRow = initialPosition.charAt(0) - '0';
        int curCol = initialPosition.charAt(1) - '0';
        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split(" -> ");
            int targetRow = inputs[1].charAt(0) - '0';
            int targetCol = inputs[1].charAt(1) - '0';
            if (targetRow == curRow || targetCol == curCol ||
                    Math.abs(targetCol - curCol) + Math.abs(targetRow - curRow) != 3) {
                countInvalidMoves++;
            } else if (targetRow < 0 || targetRow >= matrix.length ||
                    targetCol < 0 || targetCol >= matrix.length) {
                countOutsideMoves++;
            } else {
                if (matrix[targetRow][targetCol] != ' ') {
                    takenPieces.add(String.valueOf(matrix[targetRow][targetCol]));
                }
                curRow = targetRow;
                curCol = targetCol;
            }
            input = reader.readLine();
        }
        System.out.println("Pieces take: " + String.join(", ", takenPieces));
        System.out.println("Invalid moves: " + countInvalidMoves);
        System.out.println("Board out moves: " + countOutsideMoves);
    }
}
