import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyword = reader.readLine();
        String text = reader.readLine();
        Pattern sentencePattern = Pattern.compile(".*?[.?!]");
        Matcher matcher = sentencePattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            if (sentence.matches(".*?\\b" + keyword + "\\b.*")) {
                System.out.println(sentence.trim());
            }
        }
    }
}
