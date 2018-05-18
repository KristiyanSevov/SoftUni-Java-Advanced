import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1_EncryptSortPrintArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            int sum = 0;
            for (char ch : name.toCharArray()) {
                if ("aeoui".contains(String.valueOf(ch).toLowerCase())) {
                    sum += ch * name.length();
                } else
                {
                    sum += ch / name.length();
                }
            }
            nums[i] = sum;
        }
        Arrays.sort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }
}
