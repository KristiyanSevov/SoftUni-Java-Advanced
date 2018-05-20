import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class Ex10_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int elementsToEnqueue = Integer.parseInt(inputs[0]);
        int elementsToDequeue = Integer.parseInt(inputs[1]);
        int elementToCheck = Integer.parseInt(inputs[2]);
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToEnqueue; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < elementsToDequeue; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(elementToCheck)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
