import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1_RectangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        double a = Double.parseDouble(inputs[0]);
        double b = Double.parseDouble(inputs[1]);
        System.out.printf("%.2f", a * b);
    }
}
