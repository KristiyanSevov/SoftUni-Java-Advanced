import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Ex4_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int lowerBound = Integer.parseInt(inputs[0]);
        int upperBound = Integer.parseInt(inputs[1]);
        String type = reader.readLine();
        IntStream.rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(getFilter(type))
                .forEach(x -> System.out.print(x + " "));
    }

    public static Predicate<Integer> getFilter(String type) {
        if ("odd".equals(type)) {
            return x -> x % 2 != 0;
        } else {
            return x -> x % 2 == 0;
        }
    }
}
