import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Ex4_CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> regions = new TreeMap<>();
        String input = reader.readLine();
        while (!"Count em all".equals(input)) {
            String[] inputs = input.split(" -> ");
            String region = inputs[0];
            String meteorType = inputs[1];
            int meteorCount = Integer.parseInt(inputs[2]);
            regions.putIfAbsent(region, new TreeMap<>() {{
                put("Black", 0L);
                put("Red", 0L);
                put("Green", 0L);
            }});
            regions.get(region).put(meteorType, regions.get(region).get(meteorType) + meteorCount);
            if (regions.get(region).get(meteorType) >= 1000000) {
                updateValues(regions, region);
            }
            input = reader.readLine();
        }
        regions.entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String, Map<String, Long>> x) ->
                        x.getValue().get("Black"), Comparator.reverseOrder())
                        .thenComparing(x -> x.getKey().length()))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().entrySet()
                            .stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(t -> System.out.printf("-> %s : %d%n", t.getKey(), t.getValue()));
                });

    }

    private static void updateValues(Map<String,Map<String,Long>> regions, String region) {
        long greenMeteors = regions.get(region).get("Green");
        long redMeteors = regions.get(region).get("Red");
        long blackMeteors = regions.get(region).get("Black");
        if (greenMeteors >= 1000000) {
            redMeteors += greenMeteors / 1000000;
            greenMeteors %= 1000000;
        }
        if (redMeteors >= 1000000) {
            blackMeteors += redMeteors / 1000000;
            redMeteors %= 1000000;
        }
        regions.get(region).put("Green", greenMeteors);
        regions.get(region).put("Red", redMeteors);
        regions.get(region).put("Black", blackMeteors);
    }
}
