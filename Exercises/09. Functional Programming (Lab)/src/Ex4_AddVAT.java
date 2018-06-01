import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Ex4_AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        String input = reader.readLine();
        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(", "))
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(x -> System.out.printf("%.2f%n", x));
    }
}
