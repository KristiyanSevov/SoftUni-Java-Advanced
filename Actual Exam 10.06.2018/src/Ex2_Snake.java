import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[size][size];
        String[] commands = reader.readLine().split(", ");
        int currentRow = -1;
        int currentCol = -1;
        for (int i = 0; i < size; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                char ch = line[j].charAt(0);
                if (ch == 's') {
                    currentRow = i;
                    currentCol = j;
                }
                matrix[i][j] = ch;
            }
        }
        int length = 1;
        for (String command : commands) {
            switch (command) {
                case "up":
                    if (currentRow == 0) {
                        currentRow = size - 1;
                    } else {
                        currentRow--;
                    }
                    break;
                case "right":
                    if (currentCol == size - 1) {
                        currentCol = 0;
                    } else {
                        currentCol++;
                    }
                    break;
                case "down":
                    if (currentRow == size - 1) {
                        currentRow = 0;
                    } else {
                        currentRow++;
                    }
                    break;
                case "left":
                    if (currentCol == 0) {
                        currentCol = size - 1;
                    } else {
                        currentCol--;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (matrix[currentRow][currentCol] == 'f') {
                matrix[currentRow][currentCol] = '*';
                length++;
                int foodLeft = 0;
                for (int row = 0; row < size; row++) { //this part can be done much better
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col] == 'f') {
                            foodLeft++;
                        }
                    }
                }
                if (foodLeft == 0) {
                    System.out.printf("You win! Final snake length is %d%n", length);
                    return;
                }
            }

        }
        int foodLeft = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'f') {
                    foodLeft++;
                }
            }
        }
        if (foodLeft > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodLeft);
        } else {
            System.out.printf("You win! Final snake length is %d%n", length);
        }
    }
}
