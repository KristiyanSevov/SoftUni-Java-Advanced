import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13_SrabskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> data = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"End".equals(input)) {
            Pattern pattern = Pattern.compile("^(?<singer>([^ ]+ ){1,3})@(?<venue>([^ ]+ ){1,3})" +
                    "(?<price>\\d+) (?<count>\\d+)$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                Integer price = Integer.parseInt(matcher.group("price"));
                Integer count = Integer.parseInt(matcher.group("count"));
                data.putIfAbsent(venue, new LinkedHashMap<>());
                data.get(venue).putIfAbsent(singer, 0L);
                data.get(venue).put(singer, data.get(venue).get(singer) + price * count);
            }
            input = reader.readLine();
        }
        data.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet()
                    .stream()
                    .sorted((first, second) -> -first.getValue().compareTo(second.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey().trim(), singer.getValue()));
        });
    }
}