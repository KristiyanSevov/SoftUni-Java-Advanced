import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Ex2_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int num : inputs) {
            queue.offer(num);
        }
        int storageCount = 0;
        String input = reader.readLine();
        while (!"Revision".equals(input)){
            String[] command = input.split(" ");
            if ("Apply".equals(command[0])) {
                int acid = Integer.parseInt(command[2]);
                for (int i = 0; i < acid; i++) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    int item = queue.poll();
                    item -= 1;
                    if (item == 0) {
                        storageCount++;
                    } else {
                        queue.offer(item);
                    }
                }
            } else {
                int leakValue = Integer.parseInt(command[2]);
                if (storageCount > 0) {
                    storageCount--;
                    queue.offer(leakValue);
                }
            }
            input = reader.readLine();
        }
        for (Integer num : queue) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(storageCount);
    }
}