import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex8_BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> borders = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int min = Collections.min(borders);
        int max = Collections.max(borders);
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(x -> x >= min && x <= max)
                .forEach(x -> System.out.print(x + " "));
    }
}
