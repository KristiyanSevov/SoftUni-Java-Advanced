import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1_TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(x -> x >= 10 && x <= 20)
                .distinct()
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
