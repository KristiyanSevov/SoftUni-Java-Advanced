import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex6_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int num = Integer.parseInt(reader.readLine());

        Predicate<Integer> filterDivisible = x -> x % num != 0;

        for (int i = nums.size() - 1; i >= 0 ; i--) {
            if (filterDivisible.test(nums.get(i))) {
                System.out.print(nums.get(i) + " ");
            }
        }
    }
}
