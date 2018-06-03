import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        String input = reader.readLine();
        while (!"Party!".equals(input)) {
            String[] inputs = input.split(" ");
            String command = inputs[0];
            String filterType = inputs[1];
            String filterArg = inputs[2];
            if ("Double".equals(command)) {
                ArrayList<String> updatedNames = new ArrayList<>();
                for (String name : names) {
                    if (getFilter(filterType, filterArg).test(name)) {
                        updatedNames.add(name);
                    }
                    updatedNames.add(name);
                }
                names = updatedNames;
            } else if ("Remove".equals(command)) {
                names.removeIf(getFilter(filterType, filterArg));
            }
            input = reader.readLine();
        }
        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!%n", String.join(", ", names));
        }
    }

    private static Predicate<String> getFilter(String filterType, String filterArg) {
        if ("StartsWith".equals(filterType)) {
            return x -> x.startsWith(filterArg);
        } else if ("EndsWith".equals(filterType)) {
            return x -> x.endsWith(filterArg);
        } else if ("Length".equals(filterType)) {
            return x -> x.length() == Integer.parseInt(filterArg);
        } else {
            return x -> false;
        }
    }
}
