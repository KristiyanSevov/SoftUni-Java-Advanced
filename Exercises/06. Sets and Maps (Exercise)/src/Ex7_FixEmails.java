import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex7_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> people = new LinkedHashMap<>();
        while (true) {
            String name = reader.readLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = reader.readLine();
            if (email.toLowerCase().matches(".*(us|uk|com)$")) {
                continue;
            }
            people.put(name, email);
        }
        people.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
