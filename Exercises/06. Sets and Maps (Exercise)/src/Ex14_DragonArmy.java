import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex14_DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Map<String, Integer>>> data = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String type = inputs[0];
            String name = inputs[1];
            int damage = inputs[2].equals("null") ? 45 : Integer.parseInt(inputs[2]);
            int health = inputs[3].equals("null") ? 250 : Integer.parseInt(inputs[3]);
            int armor = inputs[4].equals("null") ? 10 : Integer.parseInt(inputs[4]);
            data.putIfAbsent(type, new TreeMap<>());
            data.get(type).putIfAbsent(name, new LinkedHashMap<>());
            data.get(type).get(name).put("damage", damage);
            data.get(type).get(name).put("health", health);
            data.get(type).get(name).put("armor", armor);
        }
        data.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key,
                    value.values().stream().mapToInt(x -> x.get("damage")).average().getAsDouble(),
                    value.values().stream().mapToInt(x -> x.get("health")).average().getAsDouble(),
                    value.values().stream().mapToInt(x -> x.get("armor")).average().getAsDouble());
            value.forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                    k, v.get("damage"), v.get("health"), v.get("armor")));
        });
    }
}
