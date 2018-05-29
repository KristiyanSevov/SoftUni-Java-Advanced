import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex3_Initiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<Integer, String>> stations = new TreeMap<>();
        Map<String, String> purposes = new HashMap<>();
        stations.put("Hydra", new HashMap<>());
        stations.put("Arrow", new HashMap<>());
        stations.put("Flame", new HashMap<>());
        stations.put("Pearl", new HashMap<>());
        stations.put("Orchid", new HashMap<>());
        purposes.put("Hydra", "Zoological Research.");
        purposes.put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
        purposes.put("Flame", "Communication.");
        purposes.put("Pearl", "Psychological Research and/or Observation.");
        purposes.put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");
        String input = reader.readLine();
        while (!"Recruit".equals(input)) {
            String[] inputs = input.split(":");
            String name = inputs[0];
            int number = Integer.parseInt(inputs[1]);
            String station = inputs[2];
            if (stations.containsKey(station)) {
                stations.get(station).put(number, name);
            }
            input = reader.readLine();
        }
        String command = reader.readLine();
        if ("DHARMA Initiative".equals(command)) {
            stations.entrySet()
                    .stream()
                    .sorted((x, y) -> -Integer.compare(x.getValue().size(), y.getValue().size()))
                    .forEach(x -> System.out.printf("The %s has %d DHARMA recruits in it.%n",
                            x.getKey(), x.getValue().size()));
        } else {
            String station = command;
            if (!stations.containsKey(station)) {
                System.out.println("DHARMA Initiative does not have such a station!");
            } else {
                System.out.printf("The %s station: %s%n", station, purposes.get(station));
                if (stations.get(station).size() == 0) {
                    System.out.println("No recruits.");
                } else {
                    stations.get(station).keySet()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .forEach(id -> System.out.printf("###%s - %d%n", stations.get(station).get(id), id));
                }
            }
        }
    }
}
