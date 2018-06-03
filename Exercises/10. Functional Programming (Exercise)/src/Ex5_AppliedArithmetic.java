import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex5_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = reader.readLine();
        while (!"end".equals(command)) {
            if ("print".equals(command)) {
                nums.forEach(x -> System.out.print(x + " "));
                System.out.println();
            } else {
                nums = nums.stream().map(getModifier(command)).collect(Collectors.toList());
            }
            command = reader.readLine();
        }
    }

    private static Function<Integer, Integer> getModifier(String command){
        if ("add".equals(command)) {
            return x -> x + 1;
        } else if ("subtract".equals(command)) {
            return x -> x - 1;
        } else {
            return x -> x * 2;
        }
    }
}
