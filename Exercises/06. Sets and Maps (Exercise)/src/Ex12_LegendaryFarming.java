import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex12_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyItems = new TreeMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();
        keyItems.put("motes", 0);
        keyItems.put("shards", 0);
        keyItems.put("fragments", 0);
        while (true) {
            String[] inputs = reader.readLine().split(" ");
            for (int i = 0; i < inputs.length; i += 2) {
                int quantity = Integer.parseInt(inputs[i]);
                String material = inputs[i + 1].toLowerCase();
                if (keyItems.containsKey(material)) {
                    keyItems.put(material, keyItems.get(material) + quantity);
                    if (keyItems.get(material) >= 250) {
                        printResult(material, keyItems, junkItems);
                        return;
                    }
                } else {
                    junkItems.putIfAbsent(material, 0);
                    junkItems.put(material, junkItems.get(material) + quantity);
                }
            }
        }
    }

    private static void printResult(String material, Map<String, Integer> keyItems, Map<String, Integer> junkItems) {
        String item = "";
        switch (material){
            case "shards":
                item = "Shadowmourne";
                break;
            case "fragments":
                item = "Valanyr";
                break;
            case "motes":
                item = "Dragonwrath";
                break;
        }
        System.out.println(item + " obtained!");
        keyItems.replace(material, keyItems.get(material) - 250);
        keyItems.entrySet()
                .stream()
                .sorted((x, y) -> -x.getValue().compareTo(y.getValue()))
                .forEach(x -> System.out.printf("%s: %s%n", x.getKey(), x.getValue()));
        junkItems.forEach((key, value) -> System.out.printf("%s: %s%n", key, value));
    }
}
