import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Ex2_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> printer = x -> System.out.println("Sir " + x);
        Arrays.stream(reader.readLine().split(" ")).forEach(printer);
    }
}
