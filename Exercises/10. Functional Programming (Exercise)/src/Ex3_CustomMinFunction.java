import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;


public class Ex3_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<Integer[], Integer> findMin = x -> Arrays.stream(x).mapToInt(Integer::valueOf).min().getAsInt();

        Integer[] arr = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        System.out.println(findMin.apply(arr));
    }
}
