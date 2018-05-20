import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Ex8_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int elementsToPush = Integer.parseInt(inputs[0]);
        int elementsToPop = Integer.parseInt(inputs[1]);
        int elementToCheck = Integer.parseInt(inputs[2]);
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(nums[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(stack.stream().min(Integer::compareTo).get());
        }
    }
}
