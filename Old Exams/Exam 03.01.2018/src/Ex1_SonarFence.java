import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1_SonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();
        while (!"Reprogram".equals(input)) {
            String num = Integer.toBinaryString(Integer.parseInt(input));
            char[] fullNum = new char[32];
            Arrays.fill(fullNum, '0');
            for (int i = 0; i < num.length(); i++) {
                fullNum[i + fullNum.length - num.length()] = num.charAt(i);
            }
            for (int i = 0; i < fullNum.length - 1; i++) {
                if (fullNum[i] == fullNum[i + 1]) {
                    if (fullNum[i] == '0') {
                        fullNum[i] = '1';
                        fullNum[i + 1] = '1';
                    } else {
                        fullNum[i] = '0';
                        fullNum[i + 1] = '0';
                    }
                    i++;
                }
            }         //long because of sign bit
            sb.append(Long.parseLong(new String(fullNum), 2)).append(System.lineSeparator());
            input = reader.readLine();
        }
        System.out.print(sb);
    }
}
