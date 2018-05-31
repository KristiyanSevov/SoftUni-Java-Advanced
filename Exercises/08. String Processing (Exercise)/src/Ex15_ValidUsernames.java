import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Ex15_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] usernames = Arrays.stream(reader.readLine().split("[/\\\\() ]"))
                .filter(x -> !x.isEmpty() && x.matches("[a-zA-Z][\\w]{2,24}"))
                .toArray(String[]::new);
        String bestPair = "";
        for (int i = 0; i < usernames.length - 1; i++) {
            int pairLength = usernames[i].length() + usernames[i + 1].length();
            if (pairLength > bestPair.length() - System.lineSeparator().length()) {
                bestPair = usernames[i] + System.lineSeparator() + usernames[i + 1];
            }
        }
        System.out.println(bestPair);
    }
}
