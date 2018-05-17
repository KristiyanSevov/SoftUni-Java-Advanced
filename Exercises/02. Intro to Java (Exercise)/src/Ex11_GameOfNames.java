import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_GameOfNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String bestName = null;
        int bestPoints = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            int points = Integer.parseInt(reader.readLine());
            for (char ch : name.toCharArray()) {
                if (ch % 2 == 0) {
                    points += ch;
                } else {
                    points -= ch;
                }
            }
            if (points > bestPoints) {
                bestName = name;
                bestPoints = points;
            }
        }
        System.out.printf("The winner is %s - %d points", bestName, bestPoints);
    }
}
