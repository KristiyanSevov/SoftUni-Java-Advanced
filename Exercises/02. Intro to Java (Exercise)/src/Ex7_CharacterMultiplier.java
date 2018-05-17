import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex7_CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        String first = inputs[0];
        String second = inputs[1];
        String smaller = first.length() < second.length() ? first : second;
        String bigger = first.length() < second.length() ? second : first;
        int total = 0;
        for (int i = 0; i < smaller.length(); i++) {
            total += smaller.charAt(i) * bigger.charAt(i);
        }
        for (int i = smaller.length(); i < bigger.length(); i++) {
            total += bigger.charAt(i);
        }
        System.out.println(total);
    }
}
