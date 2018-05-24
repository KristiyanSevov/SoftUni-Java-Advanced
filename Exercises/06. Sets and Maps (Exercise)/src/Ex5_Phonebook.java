import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex5_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> data = new HashMap<>();
        String input = reader.readLine();
        while (!"search".equals(input)) {
            String[] inputs = input.split("-");
            String name = inputs[0];
            String number = inputs[1];
            data.put(name, number);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!"stop".equals(input)) {
            if (data.containsKey(input)) {
                System.out.println(input + " -> " + data.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = reader.readLine();
        }
    }
}
