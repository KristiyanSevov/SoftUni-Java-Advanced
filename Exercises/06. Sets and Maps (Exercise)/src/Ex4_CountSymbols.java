import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex4_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> counts = new TreeMap<>();
        String text = reader.readLine();
        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            counts.putIfAbsent(ch, 0);
            counts.put(ch, counts.get(ch) + 1);
        }
        counts.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
