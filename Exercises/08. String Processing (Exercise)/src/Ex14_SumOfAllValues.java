import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex14_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keysString = reader.readLine();
        String text = reader.readLine();
        Pattern startPattern = Pattern.compile("^[a-zA-Z_]+(?=\\d)");
        Pattern endPattern = Pattern.compile("(?<=\\d)[a-zA-Z_]+$");
        Matcher startMatcher = startPattern.matcher(keysString);
        Matcher endMatcher = endPattern.matcher(keysString);
        if (!startMatcher.find() || !endMatcher.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }
        Pattern pattern = Pattern.compile(startMatcher.group() + "(\\d+|\\d*\\.\\d*)" + endMatcher.group());
        Matcher matcher = pattern.matcher(text);
        double sum = 0;
        while (matcher.find()) {
            sum += Double.parseDouble(matcher.group(1));
        }
        String formattedSum = sum % 1 == 0 ? String.valueOf((int) sum) : String.format("%.2f", sum);
        System.out.printf("<p>The total value is: <em>%s</em></p>", sum != 0 ? formattedSum : "nothing");
    }
}