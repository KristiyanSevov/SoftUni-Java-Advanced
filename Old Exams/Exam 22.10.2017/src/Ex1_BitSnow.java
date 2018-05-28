import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1_BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int j = 0; j < nums.length; j++) { //takes care of cases when a spot gets available later
            for (int i = 0; i < nums.length - 1; i++) {
                int temp = nums[i];
                nums[i] = nums[i] & nums[i + 1];
                nums[i + 1] = nums[i + 1] | temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
