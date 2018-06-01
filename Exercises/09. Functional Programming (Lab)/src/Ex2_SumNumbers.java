import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex2_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String, Integer> myIntParse = x -> Integer.parseInt(x);

        List<Integer> nums = Arrays.stream(reader.readLine().split(", "))
                .map(myIntParse)
                .collect(Collectors.toList());

        System.out.println("Count = " + nums.size());
        System.out.println("Sum = " + nums.stream().mapToInt(Integer::valueOf).sum());
    }
}
