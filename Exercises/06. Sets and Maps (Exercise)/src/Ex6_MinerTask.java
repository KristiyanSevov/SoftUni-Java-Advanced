import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex6_MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> resources = new LinkedHashMap<>();
        while (true) {
            String resource = reader.readLine();
            if ("stop".equals(resource)) {
                break;
            }
            int quantity = Integer.parseInt(reader.readLine());
            resources.putIfAbsent(resource, 0L);
            resources.put(resource, resources.get(resource) + quantity);
        }
        resources.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
