import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex4_CountsSameValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        Map<String, Integer> counts = new HashMap<>();
        for (String str : inputs){
            counts.putIfAbsent(str, 0);
            counts.put(str, counts.get(str) + 1);
        }
        counts.forEach((key, value) -> System.out.printf("%s - %d times%n", key, value));
    }
}
