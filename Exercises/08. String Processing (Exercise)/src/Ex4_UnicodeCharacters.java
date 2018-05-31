import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4_UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(String.format("\\u%04x", (int) text.charAt(i)));
        }
        System.out.println(result);
    }
}
