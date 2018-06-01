import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex16_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String input = reader.readLine();
        while (!"END".equals(input)){
            text.append(input);
            input = reader.readLine();
        }
        Pattern pattern = Pattern.compile("<a[^>]+?href\\s*=\\s*(\".*?\"|'.*?'|.*?)[\\s>]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group(1);
            if (match.startsWith("\"") || match.startsWith("'")) {
                match = match.substring(1, match.length() - 1);
            }
            System.out.println(match);
        }
    }
}
