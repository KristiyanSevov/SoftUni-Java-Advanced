import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex8_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        int turns = Integer.parseInt(reader.readLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : names){
            queue.offer(name);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < turns - 1; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
