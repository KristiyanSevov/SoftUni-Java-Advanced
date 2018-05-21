import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ex16_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine(); //not really needed
        String[] inputs = reader.readLine().split(" ");
        long[] nums = new long[inputs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(inputs[i]); //parsing with stream too slow here
        }
        int[] turns = new int[nums.length];
        Deque<Integer> indices = new ArrayDeque<>();
        indices.push(0);
        for (int i = 1; i < nums.length; i++) {
            int maxTurns = 0;
            while (!indices.isEmpty() && nums[indices.peek()] >= nums[i])
            {
                maxTurns = Math.max(maxTurns, turns[indices.pop()]);
            }
            if (!indices.isEmpty()) { //if empty, no smaller elems => won't be deleted => 0
                turns[i] = maxTurns + 1; //have to wait for the >= elems to be deleted (maxTurns), then delete
            }
            indices.push(i);
        }
        int maxTurns = 0;
        for (int turn : turns){
            if (turn > maxTurns) {
                maxTurns = turn;
            }
        }
        System.out.println(maxTurns);
    }
}
