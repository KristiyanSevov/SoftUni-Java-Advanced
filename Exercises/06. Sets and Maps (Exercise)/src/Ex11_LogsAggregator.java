import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex11_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> data = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String IP = inputs[0];
            String name = inputs[1];
            int duration = Integer.parseInt(inputs[2]);
            data.putIfAbsent(name, new TreeMap<>());
            data.get(name).putIfAbsent(IP, 0);
            data.get(name).put(IP, data.get(name).get(IP) + duration);
        }
        data.forEach((key, value) -> {
            System.out.printf("%s: %d [%s]%n", key,
                    value.values().stream().mapToInt(Integer::valueOf).sum(),
                    String.join(", ", value.keySet()));
        });
    }
}
