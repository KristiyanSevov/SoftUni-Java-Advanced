import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class Ex6_FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Optional<Integer> sum = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> x.matches("-?\\d+"))
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);
        if (sum.isPresent()) {
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }
}
