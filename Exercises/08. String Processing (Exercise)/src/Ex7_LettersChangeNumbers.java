import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex7_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        System.out.printf("%.2f", Arrays.stream(inputs)
                .mapToDouble(x -> calcValue(x))
                .sum());
    }

    private static double calcValue(String x) {
        Character first = x.charAt(0);
        Character last = x.charAt(x.length() - 1);
        Double number = Double.parseDouble(x.substring(1, x.length() - 1));
        if (Character.isUpperCase(first)) {
            number /= first - 'A' + 1;
        } else {
            number *= first - 'a' + 1;
        }
        if (Character.isUpperCase(last)) {
            number -= last - 'A' + 1;
        } else {
            number += last - 'a' + 1;
        }
        return number;
    }
}
