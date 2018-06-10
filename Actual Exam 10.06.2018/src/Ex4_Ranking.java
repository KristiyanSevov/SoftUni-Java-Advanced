import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Ex4_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new HashMap<>();
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = reader.readLine();
        while (!"end of contests".equals(input)) {
            String[] inputs = input.split(":");
            String contest = inputs[0];
            String password = inputs[1];
            contests.put(contest, password);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!"end of submissions".equals(input)) {
            String[] inputs = input.split("=>");
            String contest = inputs[0];
            String password = inputs[1];
            String username = inputs[2];
            int points = Integer.parseInt(inputs[3]);
            if (!contests.containsKey(contest) || !contests.get(contest).equals(password)) {
                input = reader.readLine();
                continue;
            }
            users.putIfAbsent(username, new LinkedHashMap<>());
            if (users.get(username).containsKey(contest)) {
                if (users.get(username).get(contest) >= points) {
                    input = reader.readLine();
                    continue;
                }
            }
            users.get(username).put(contest, points);
            input = reader.readLine();
        }
        String bestUser = users.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue().values().stream().mapToInt(Integer::valueOf).sum(),
                        Comparator.reverseOrder()))
                .findFirst()
                .get()
                .getKey();
        System.out.printf("Best candidate is %s with total %d points.%n",
                bestUser, users.get(bestUser).values().stream().mapToInt(Integer::valueOf).sum());
        System.out.println("Ranking:");
        users.entrySet()
                .stream()
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().entrySet()
                            .stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(c -> System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue()));
                });
    }
}
