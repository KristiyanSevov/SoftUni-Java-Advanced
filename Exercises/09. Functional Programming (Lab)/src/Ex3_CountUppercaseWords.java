import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex3_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isUppercase = x -> x.charAt(0) == x.toUpperCase().charAt(0); //judge tests...

        List<String> uppercaseWords = Arrays.stream(reader.readLine().split(" "))
                        .filter(isUppercase)
                        .collect(Collectors.toList());
        System.out.println(uppercaseWords.size());
        System.out.println(String.join(System.lineSeparator(), uppercaseWords));
    }
}
