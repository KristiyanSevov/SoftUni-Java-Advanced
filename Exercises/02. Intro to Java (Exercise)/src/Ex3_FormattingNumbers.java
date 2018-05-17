import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3_FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int first = Integer.parseInt(inputs[0]);
        double second = Double.parseDouble(inputs[1]);
        double third = Double.parseDouble(inputs[2]);
        String hexFormat = Integer.toHexString(first).toUpperCase();
        String binaryFormat = String.format("%10s", Integer.toBinaryString(first)).replace(" ", "0");
        String thirdFormat = String.format("%.2f", second);
        String lastFormat = String.format("%.3f", third);
        System.out.printf("|%-10s|%s|%10s|%-10s|", hexFormat, binaryFormat, thirdFormat, lastFormat);
    }
}
