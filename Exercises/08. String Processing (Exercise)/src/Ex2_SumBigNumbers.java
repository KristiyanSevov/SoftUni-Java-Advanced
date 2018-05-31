import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex2_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNum = reader.readLine();
        String secondNum = reader.readLine();
        int size = Math.max(firstNum.length(), secondNum.length());
        String first = String.format("%0" + size + "d", new BigInteger(firstNum));
        String second = String.format("%0" + size + "d", new BigInteger(secondNum));
        StringBuilder result = new StringBuilder();
        int overflow = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = first.charAt(i) - '0' + second.charAt(i) - '0' + overflow;
            result.append(sum % 10);
            overflow = sum / 10;
        }
        if (overflow == 1) {
            result.append('1');
        }
        System.out.println(result.reverse().toString().replaceFirst("^0+(?!$)", ""));
    }
}
