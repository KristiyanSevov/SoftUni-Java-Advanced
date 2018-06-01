import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex5_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(", ");
            String name = inputs[0];
            int age = Integer.parseInt(inputs[1]);
            people.put(name, age);
        }
        String ageCondition = reader.readLine();
        int ageBorder = Integer.parseInt(reader.readLine());
        String printFormat = reader.readLine();

        people.entrySet()
                .stream()
                .filter(getFilter(ageCondition, ageBorder))
                .forEach(getPrinter(printFormat));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrinter(String printFormat) {
        if ("name".equals(printFormat)) {
            return x -> System.out.println(x.getKey());
        } else if ("age".equals(printFormat)) {
            return x -> System.out.println(x.getValue());
        } else {
            return x -> System.out.printf("%s - %d%n", x.getKey(), x.getValue());
        }
    }

    private static Predicate<Map.Entry<String, Integer>> getFilter(String ageCondition, int ageBorder) {
        if ("younger".equals(ageCondition)) {
            return x -> x.getValue() < ageBorder;
        } else {
            return x -> x.getValue() >= ageBorder;
        }
    }
}
