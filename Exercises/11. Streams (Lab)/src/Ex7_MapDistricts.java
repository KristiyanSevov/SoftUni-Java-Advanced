import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex7_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> cities = new HashMap<>();
        String[] pairs = reader.readLine().split(" ");
        int minPopulation = Integer.parseInt(reader.readLine());
        for (String pair : pairs) {
            String[] tokens = pair.split(":");
            String name = tokens[0];
            Integer population = Integer.valueOf(tokens[1]);
            cities.putIfAbsent(name, new ArrayList<>());
            cities.get(name).add(population);
        }

        Map<String, Integer> totalPopulations = new HashMap<>();
        for (String key : cities.keySet()){
            totalPopulations.put(key, cities.get(key).stream().mapToInt(Integer::valueOf).sum());
        }

        cities.entrySet()
                .stream()
                .filter(x -> totalPopulations.get(x.getKey()) > minPopulation)
                .sorted(Comparator.comparing(x -> totalPopulations.get(x.getKey()), Comparator.reverseOrder()))
                .forEach(x -> {
                    System.out.print(x.getKey() + ": ");
                    x.getValue()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(p -> System.out.print(p + " "));
                    System.out.println();
                });
    }
}
