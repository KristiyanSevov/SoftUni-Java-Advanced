import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex4_Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> players = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"osu!".equals(input)) {
            String[] inputs = input.split("<->");
            String[] firstPlayerData = inputs[0].split(" ");
            int firstPoints = Integer.parseInt(firstPlayerData[0]);
            String firstName = firstPlayerData[1];
            String[] secondPlayerData = inputs[1].split(" ");
            String secondName = secondPlayerData[0];
            int secondPoints = Integer.parseInt(secondPlayerData[1]);

            players.putIfAbsent(firstName, new ArrayList<>());
            players.putIfAbsent(secondName, new ArrayList<>());
            players.get(firstName).add(String.format("%s <-> %d", secondName, firstPoints - secondPoints));
            players.get(secondName).add(String.format("%s <-> %d", firstName, secondPoints - firstPoints));

            input = reader.readLine();
        }
        Map<String, Long> totalPoints = new HashMap<>();
        for (String player : players.keySet()) {
            totalPoints.put(player, players.get(player).stream()
                    .mapToLong(s -> Long.parseLong(s.split(" <-> ")[1]))
                    .sum());
        }
        players.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> totalPoints.get(x.getKey()), Comparator.reverseOrder()))
                .forEach(x -> {
                    System.out.printf("%s - (%d)%n", x.getKey(), totalPoints.get(x.getKey()));
                    x.getValue().forEach(s -> System.out.printf("*   %s%n", s));
                });
    }
}
