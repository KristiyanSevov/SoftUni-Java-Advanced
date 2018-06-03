import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Ex7_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = Integer.parseInt(reader.readLine());
        Predicate<String> lengthFilter = x -> x.length() <= maxLength;
        Arrays.stream(reader.readLine().split(" "))
                .filter(lengthFilter)
                .forEach(System.out::println);
    }
}
