import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_LetterExpression { //problem is wrongly stated, judge expects no doubles
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Pattern pattern = Pattern.compile("(?<number>\\d+)(?<middle>.*?)(?=-?\\d|$)");
        Matcher matcher = pattern.matcher(text);
        char prevOperation = '+';
        int total = 0;
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group("number"));
            total = prevOperation == '+' ? total + num : total - num;
            if (matcher.group("middle").length() % 2 == 0) {
                prevOperation = '+';
            } else {
                prevOperation = '-';
            }
        }
        System.out.println(total);
    }
}