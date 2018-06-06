import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex2_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<LinkedList<Integer>> sequenceQueue = new ArrayDeque<>();
        List<Integer> hitWaves = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> sequence = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
            sequenceQueue.offer(sequence);
        }
        while (!sequenceQueue.isEmpty()) {
            LinkedList<Integer> sequence = sequenceQueue.poll();
            int wave = sequence.removeFirst();
            hitWaves.add(wave);
            while (sequence.size() > 0 && sequence.getFirst() <= wave) {
                sequence.removeFirst();
            }
            if (sequence.size() > 0) {
                sequenceQueue.offer(sequence);
            }
        }
        System.out.println(hitWaves.size());
        StringBuilder sb = new StringBuilder();
        hitWaves.forEach(x -> sb.append(x).append(" "));
        System.out.println(sb);
    }
}
