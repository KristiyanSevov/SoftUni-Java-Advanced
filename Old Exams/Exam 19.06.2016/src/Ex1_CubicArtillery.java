import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Ex1_CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> bunkers = new ArrayDeque<>();
        Map<String, ArrayDeque<Integer>> bunkerData = new HashMap<>();
        Map<String, Integer> bunkerSums = new HashMap<>();
        StringBuilder result = new StringBuilder();

        int maxCapacity = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        while (!"Bunker Revision".equals(input)) {
            String[] inputs = input.split(" ");
            for (String token : inputs) {
                if (Character.isAlphabetic(token.charAt(0))) {
                    bunkers.addLast(token);
                    bunkerData.put(token, new ArrayDeque<>());
                    bunkerSums.put(token, 0);
                } else {
                    int weapon = Integer.parseInt(token);
                    while (bunkers.size() > 1) {
                        String bunker = bunkers.getFirst();
                        int bunkerLoad = bunkerSums.get(bunker);
                        if (bunkerLoad + weapon <= maxCapacity) {
                            bunkerData.get(bunker).addLast(weapon);
                            bunkerSums.put(bunker, bunkerSums.get(bunker) + weapon);
                            break;
                        } else {
                            String overflowed = bunkers.removeFirst();
                            ArrayDeque<Integer> weapons = bunkerData.get(overflowed);
                            result.append(String.format("%s -> %s%n", overflowed,
                                    weapons.isEmpty() ? "Empty" : weapons
                                            .stream().map(String::valueOf).collect(Collectors.joining(", "))));
                            bunkerData.remove(overflowed);
                            bunkerSums.remove(overflowed);
                        }
                    }
                    while (true) { //handle the last bunker
                        if (weapon > maxCapacity) {
                            break;
                        }
                        String bunker = bunkers.getFirst();
                        int lastBunkerLoad = bunkerSums.get(bunker);
                        if (lastBunkerLoad + weapon <= maxCapacity) {
                            bunkerData.get(bunker).addLast(weapon);
                            bunkerSums.put(bunker, bunkerSums.get(bunker) + weapon);
                            break;
                        }
                        int removed = bunkerData.get(bunker).removeFirst();
                        bunkerSums.put(bunker, bunkerSums.get(bunker) - removed);
                    }
                }
            }
            input = reader.readLine();
        }
        System.out.println(result);
    }
}