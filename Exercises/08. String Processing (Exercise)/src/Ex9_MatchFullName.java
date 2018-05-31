import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex9_MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!"end".equals(input)){
            if (input.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }
}
