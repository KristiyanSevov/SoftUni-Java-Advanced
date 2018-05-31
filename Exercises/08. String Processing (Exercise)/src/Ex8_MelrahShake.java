import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex8_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());
        int firstMatchIndex = text.indexOf(pattern.toString());
        int lastMatchIndex = text.lastIndexOf(pattern.toString());
        while (pattern.length() > 0 && firstMatchIndex != lastMatchIndex &&
                firstMatchIndex != -1 && lastMatchIndex != -1 ) {
            text.delete(lastMatchIndex, lastMatchIndex + pattern.length());
            text.delete(firstMatchIndex, firstMatchIndex + pattern.length());
            System.out.println("Shaked it.");
            pattern.deleteCharAt(pattern.length() / 2);
            firstMatchIndex = text.indexOf(pattern.toString());
            lastMatchIndex = text.lastIndexOf(pattern.toString());
        }
        System.out.println("No shake.");
        System.out.println(text);
    }
}
