import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex5_OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (nums.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }
        for (int i = 0; i < nums.length; i += 2) {
            int first = nums[i];
            int second = nums[i + 1];
            if (first % 2 == 0 && second % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", first, second);
            } else if (first % 2 != 0 && second % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", first, second);
            } else {
                System.out.printf("%d, %d -> different%n", first, second);
            }
        }
    }
}
