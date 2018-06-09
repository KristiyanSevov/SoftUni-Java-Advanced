import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_CubicMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^\\d+([a-zA-Z]+)[^a-zA-Z]*$");
        String text = reader.readLine();
        while (!"Over!".equals(text)) {
            int length = Integer.parseInt(reader.readLine());
            Matcher matcher = pattern.matcher(text);
            if (matcher.find() && matcher.group(1).length() == length) {
                String message = matcher.group(1);
                StringBuilder decoded = new StringBuilder();
                for (int i = 0; i < text.length(); i++) {
                    if (Character.isDigit(text.charAt(i))) {
                        int index = text.charAt(i) - '0';
                        decoded.append(index >= message.length() ? " " : message.charAt(index));
                    }
                }
                System.out.println(message + " == " + decoded);
            }
            text = reader.readLine();
        }
    }
}
