import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex3_VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> following = new HashMap<>();
        Map<String, Set<String>> followers = new HashMap<>();
        String input = reader.readLine();
        while (!"Statistics".equals(input)) {
            String[] inputs = input.split(" ");
            if ("joined".equals(inputs[1])) {
                String name = inputs[0];
                following.putIfAbsent(name, new HashSet<>());
                followers.putIfAbsent(name, new TreeSet<>());
            } else {
                String follower = inputs[0];
                String followed = inputs[2];
                if (!followed.equals(follower) && following.containsKey(follower) && following.containsKey(followed)) {
                    following.get(follower).add(followed);
                    followers.get(followed).add(follower);
                }
            }
            input = reader.readLine();
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", followers.size());
        List<String> sortedNames = followers.keySet()
                .stream()
                .sorted(Comparator.comparing(
                        (String x) -> followers.get(x).size(), Comparator.reverseOrder())
                        .thenComparing(x -> following.get(x).size()))
                .collect(Collectors.toList());
        int counter = 1;
        for (String name : sortedNames) {
            System.out.printf("%d. %s : %d followers, %d following%n",
                    counter, name, followers.get(name).size(), following.get(name).size());
            if (counter == 1) {
                followers.get(name).forEach(x -> System.out.printf("*  %s%n", x));
            }
            counter++;
        }
    }
}