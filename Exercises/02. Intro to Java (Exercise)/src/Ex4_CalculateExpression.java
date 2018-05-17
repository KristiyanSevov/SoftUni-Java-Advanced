import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4_CalculateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        double a = Double.parseDouble(inputs[0]);
        double b = Double.parseDouble(inputs[1]);
        double c = Double.parseDouble(inputs[2]);
        double f1 = Math.pow((a*a + b*b) / (double)(a*a - b*b), (a + b + c) / Math.sqrt(c));
        double f2 = Math.pow(a*a + b*b - c*c*c, a - b);
        double diff = Math.abs((a + b + c) / 3.0 - ((f1 + f2) / 2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}
