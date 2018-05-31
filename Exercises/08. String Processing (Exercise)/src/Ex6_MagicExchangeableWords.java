import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex6_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        System.out.println(areExchangeable(inputs[0], inputs[1]));
    }

    private static boolean areExchangeable(String first, String second) {
        return first.chars().distinct().count() == second.chars().distinct().count();
    }
}
