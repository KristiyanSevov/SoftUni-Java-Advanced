import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex8_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, HashSet<String>> players = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"JOKER".equals(input)) {
            String[] inputs = input.split(": ");
            String name = inputs[0];
            players.putIfAbsent(name, new HashSet<>());
            for (String card : inputs[1].split(", ")){
                players.get(name).add(card);
            }
            input = reader.readLine();
        }
        Map<Character, Integer> values = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            values.put((char)(i + '0'), i);
        }
        values.put('J', 11);
        values.put('Q', 12);
        values.put('K', 13);
        values.put('A', 14);
        values.put('S', 4);
        values.put('H', 3);
        values.put('D', 2);
        values.put('C', 1);
        players.forEach((key, value) -> {
            int sum = 0;
            for (String card : value) {
                if (card.matches("10.")) {
                    sum += 10 * values.get(card.charAt(2));
                } else {
                    sum += values.get(card.charAt(0)) * values.get(card.charAt(1));
                }
            }
            System.out.printf("%s: %d%n", key, sum);
        });
    }
}
