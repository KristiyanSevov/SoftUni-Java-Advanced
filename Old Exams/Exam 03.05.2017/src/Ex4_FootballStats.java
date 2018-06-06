import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex4_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> teams = new HashMap<>();
        String input = reader.readLine();
        while (!"Season End".equals(input)) {
            String[] inputs = input.split(" result ");
            String[] teamNames = inputs[0].split(" - ");
            String homeTeam = teamNames[0];
            String guestTeam = teamNames[1];
            String score = inputs[1];
            teams.putIfAbsent(homeTeam, new ArrayList<>());
            teams.putIfAbsent(guestTeam, new ArrayList<>());
            teams.get(homeTeam).add(guestTeam + " -> " + score);
            teams.get(guestTeam).add(homeTeam + " -> " + new StringBuilder(score).reverse().toString());
            input = reader.readLine();
        }
        String[] teamsToPrint = reader.readLine().split(", ");
        for (String team : teamsToPrint) {
            teams.get(team)
                    .stream()
                    .sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
                    .forEach(x -> System.out.println(team + " - " + x));
        }
    }
}
