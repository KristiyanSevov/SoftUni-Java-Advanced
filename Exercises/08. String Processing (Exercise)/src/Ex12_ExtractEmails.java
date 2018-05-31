import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(^| )(?<email>[a-zA-Z0-9][\\w.-]*@[\\w][\\w-]*(\\.[\\w][\\w-]*)+)([., ]|$)");
        String input = reader.readLine();
        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group("email"));
            }
            input = reader.readLine();
        }
    }
}
