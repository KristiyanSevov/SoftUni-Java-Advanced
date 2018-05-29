import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4_SwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> mainNums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            queue.offer(num);
        }
        while (results.size() < 6) {
            int num = queue.poll();
            if (num % mainNums.get(0) == 0) {
                results.add(num);
                mainNums.remove(0);
            } else {
                queue.offer(num + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : results) {
            sb.append(num).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }
}
