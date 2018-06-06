import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1_SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> secondNature = new ArrayList<>();
        ArrayDeque<Integer> flowers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> buckets = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toCollection(ArrayDeque::new));
        while (flowers.size() > 0 && buckets.size() > 0){
            Integer flower = flowers.removeFirst();
            Integer bucket = buckets.removeLast();
            if (bucket < flower) {
                flowers.addFirst(flower - bucket);
            } else if (bucket > flower){
                if (buckets.size() > 0) {
                    buckets.addLast(buckets.removeLast() + bucket - flower);
                } else {
                    buckets.addLast(bucket - flower);
                }
            } else {
                secondNature.add(flower);
            }
        }
        if (flowers.size() == 0) {
            buckets.descendingIterator().forEachRemaining(x -> System.out.print(x + " "));
            System.out.println();
        } else {
            flowers.forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
        if (secondNature.size() == 0) {
            System.out.println("None");
        } else {
            secondNature.forEach(x -> System.out.print(x + " "));
        }
    }
}