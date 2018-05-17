import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex8_FirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] inputs = reader.readLine().split("\\s+");
        int count = Integer.parseInt(inputs[1]);
        boolean even = inputs[2].equals("even");
        for (int num : nums) {
            if (even ? num % 2 == 0 : num % 2 != 0) {
                System.out.print(num + " ");
                count--;
            }
            if (count == 0) {
                break;
            }
        }
    }
}
