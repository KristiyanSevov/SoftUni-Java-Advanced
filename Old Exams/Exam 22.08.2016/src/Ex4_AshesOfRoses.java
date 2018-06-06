import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex4_AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> regions = new TreeMap<>();
        Pattern pattern = Pattern.compile("^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)$");
        String input = reader.readLine();
        while (!"Icarus, Ignite!".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String region = matcher.group(1);
                String color = matcher.group(2);
                int amount = Integer.parseInt(matcher.group(3));
                regions.putIfAbsent(region, new TreeMap<>());
                regions.get(region).putIfAbsent(color, 0L);
                regions.get(region).put(color, regions.get(region).get(color) + amount);
            }
            input = reader.readLine();
        }
        regions.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue().values().stream().mapToLong(Long::valueOf).sum(),
                        Comparator.reverseOrder()))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().entrySet()
                            .stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue))
                            .forEach(c -> System.out.printf("*--%s | %d%n", c.getKey(), c.getValue()));
                });
    }
}