import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex3_NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>();
        StringBuilder text = new StringBuilder();
        String line = reader.readLine();
        while (!"---NMS SEND---".equals(line)) {
            text.append(line);
            line = reader.readLine();
        }
        StringBuilder word = new StringBuilder();
        word.append(text.charAt(0));
        String prev = String.valueOf(text.charAt(0)).toLowerCase();
        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            String lowered = String.valueOf(ch).toLowerCase();
            if (lowered.compareTo(prev) >= 0) {
                word.append(ch);
            } else {
                words.add(word.toString());
                word = new StringBuilder();
                word.append(ch);
            }
            prev = lowered;
        }
        words.add(word.toString());
        String delimiter = reader.readLine();
        System.out.println(String.join(delimiter, words));
    }
}
