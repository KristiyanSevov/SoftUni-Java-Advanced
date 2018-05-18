import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex2_SplitByWordCasing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("[,;:.!()\"'/\\[\\]\\\\ ]");
        List<String> lowercase = new ArrayList<>();
        List<String> uppercase = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        for (String word : words){
            if (!word.equals("")) {
                if (word.matches("[A-Z]+")) {
                    uppercase.add(word);
                } else if (word.matches("[a-z]+")){
                    lowercase.add(word);
                } else {
                    mixed.add(word);
                }
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lowercase));
        System.out.println("Mixed-case: " + String.join(", ", mixed));
        System.out.println("Upper-case: " + String.join(", ", uppercase));
    }
}
