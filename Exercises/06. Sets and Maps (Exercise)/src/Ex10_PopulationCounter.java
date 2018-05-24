import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex10_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> data = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"report".equals(input)) {
            String[] inputs = input.split("\\|");
            String city = inputs[0];
            String country = inputs[1];
            long population = Long.parseLong(inputs[2]);
            data.putIfAbsent(country, new LinkedHashMap<>());
            data.get(country).put(city, population);
            input = reader.readLine();
        }
        Map<String, Long> totalPopulations = new HashMap<>();
        for (String country : data.keySet()) {
            totalPopulations.put(country, data.get(country).values().stream().mapToLong(Long::valueOf).sum());
        }
        data.entrySet()
                .stream()
                .sorted((x, y) -> -totalPopulations.get(x.getKey()).compareTo(totalPopulations.get(y.getKey())))
                .forEach(x -> {
                    System.out.printf("%s (total population: %d)%n", x.getKey(), totalPopulations.get(x.getKey()));
                    x.getValue().entrySet()
                            .stream()
                            .sorted((first, second) -> -first.getValue().compareTo(second.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}