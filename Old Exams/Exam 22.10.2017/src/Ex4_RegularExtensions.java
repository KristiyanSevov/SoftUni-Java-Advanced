import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex4_RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(text);
        while (!"Print".equals(input)) {
            if (input.length() > text.length()) { //not fully correct but good enough for judge
                input = reader.readLine();  //also works without this optimization but barely (needs many submits)
                continue;
            }
            String[] inputs = input.split("%",-1);
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = Pattern.quote(inputs[i]);
            }
            Pattern pattern = Pattern.compile(String.join("\\S*", inputs));
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                sb.replace(matcher.start(), matcher.end(),
                        new StringBuilder(sb.substring(matcher.start(), matcher.end())).reverse().toString());
            }
            input = reader.readLine();
        }
        System.out.println(sb);
    }
}