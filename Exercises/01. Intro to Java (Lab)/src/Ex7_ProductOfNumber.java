import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex7_ProductOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        BigInteger total = BigInteger.ONE;
        for (int i = n; i <= m; i++) {
            total = total.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("product[%d..%d] = %s", n, m, total);
    }
}
