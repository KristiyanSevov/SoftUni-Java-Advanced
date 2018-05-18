import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex6_DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(reader.readLine());
        if (decimal == 0) {
            System.out.println(0);
            return;
        }
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (decimal != 0) {
            stack.push(String.valueOf(decimal % 2));
            decimal /= 2;
        }
        System.out.println(String.join("", stack));
    }
}
