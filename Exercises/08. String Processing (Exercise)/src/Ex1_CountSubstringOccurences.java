import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1_CountSubstringOccurences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().toLowerCase();
        String inputPattern = reader.readLine().toLowerCase();
        int index = text.indexOf(inputPattern);
        int counter = 0;
        while (index != -1) {
            counter++;
            index = text.indexOf(inputPattern, index + 1);
        }
        System.out.println(counter);
    }
}
