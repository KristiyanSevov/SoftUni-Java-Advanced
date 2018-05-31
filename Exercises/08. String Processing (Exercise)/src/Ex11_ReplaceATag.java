import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex11_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            text.append(input).append(System.lineSeparator());
            input = reader.readLine();
        }
        Pattern pattern = Pattern.compile("<a\\s+(href=.*?)>((.|\\s)*?)</a>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            text.replace(matcher.start(), matcher.end(),
                    "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]");
            matcher = pattern.matcher(text);
        }
        System.out.println(text);
    }
}
