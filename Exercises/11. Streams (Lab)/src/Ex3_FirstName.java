import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex3_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split(" ");
        Set<Character> letters = Arrays.stream(reader.readLine().split(" "))
                .map(x -> x.toLowerCase().charAt(0))
                .collect(Collectors.toSet());
        Optional<String> name = Arrays.stream(names)
                .filter(x -> letters.contains(x.toLowerCase().charAt(0)))
                .sorted()
                .findAny();
        if (name.isPresent()) {
            System.out.println(name.get());
        } else {
            System.out.println("No match");
        }
    }
}
