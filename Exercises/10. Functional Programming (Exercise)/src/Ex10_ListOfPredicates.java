import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex10_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxBorder = Integer.parseInt(reader.readLine());
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).distinct().collect(Collectors.toList());

        IntPredicate customFilter = x -> {
            for (int num : nums){
                if (x % num != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, maxBorder)
                .filter(customFilter)
                .forEach(x -> System.out.print(x + " "));
    }
}