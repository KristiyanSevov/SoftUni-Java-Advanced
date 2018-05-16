import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10_ModifyABit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int num = Integer.parseInt(inputs[0]);
        int bitIndex = Integer.parseInt(inputs[1]);
        int newValue = Integer.parseInt(inputs[2]);
        if (newValue == 0) {
            System.out.println((~(1 << bitIndex)) & num);
        } else {
            System.out.println((1 << bitIndex) | num);
        }
    }
}