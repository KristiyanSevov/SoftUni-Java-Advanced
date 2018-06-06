import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> decodedPatterns = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([,_])([a-zA-Z]+)(\\d)");
        String text = reader.readLine();
        while (!"Ascend".equals(text)) {
            for (String p : decodedPatterns.keySet()) {
                text = text.replaceAll(Pattern.quote(p), decodedPatterns.get(p));
            }
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                String match = matcher.group(0);
                String operator = matcher.group(1);
                String letters = matcher.group(2);
                int digit = Integer.parseInt(matcher.group(3));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < letters.length(); i++) {
                    if (operator.equals(",")) {
                        sb.append((char)(letters.charAt(i) + digit));
                    } else {
                        sb.append((char)(letters.charAt(i) - digit));
                    }
                }
                String replacement = sb.toString();
                decodedPatterns.put(match, replacement);
                text = text.replaceAll(match, replacement);
            }
            System.out.println(text);
            text = reader.readLine();
        }
    }
}