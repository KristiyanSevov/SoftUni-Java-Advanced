import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2_CubicRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(reader.readLine());
        long totalSum = 0;
        long totalHits = 0;
        String input = reader.readLine();
        while (!"Analyze".equals(input)) {
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (data[0] >= 0 && data[1] >= 0 && data[2] >= 0 &&
                    data[0] < n && data[1] < n && data[2] < n &&
                    data[3] != 0) {
                totalSum += data[3];
                totalHits++;
            }
            input = reader.readLine();
        }
        System.out.println(totalSum);
        System.out.println(n * n * n - totalHits);
    }
}