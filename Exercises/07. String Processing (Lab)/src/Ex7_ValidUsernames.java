import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder results = new StringBuilder();
        boolean valid = false;
        String input = reader.readLine();
        while (!"END".equals(input)){
            if (input.matches("[\\w-]{3,16}")) {
                valid = true;
                results.append("valid");
            } else {
                results.append("invalid");
            }
            results.append(System.lineSeparator());
            input = reader.readLine();
        }
        if (valid) {
            System.out.print(results);
        }
    }
}
