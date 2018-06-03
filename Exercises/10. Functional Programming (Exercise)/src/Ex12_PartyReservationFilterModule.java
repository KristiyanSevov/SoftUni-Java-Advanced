import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex12_PartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        HashSet<String> filterStrings = new HashSet<>();
        String input = reader.readLine();
        while (!"Print".equals(input)) {
            String[] inputs = input.split(";", 2);
            String command = inputs[0];
            String filterString = inputs[1];
            if ("Add filter".equals(command)) {
                filterStrings.add(filterString);
            } else if ("Remove filter".equals(command)) {
                filterStrings.remove(filterString);
            }
            input = reader.readLine();
        }

        Predicate<String> combinedFilter = x -> {
            for (String filterString : filterStrings) {
                if (generateFilter(filterString).test(x)) {
                    return false;
                }
            }
            return true; //doesn't match any of the filters
        };

        names.stream()
                .filter(combinedFilter)
                .forEach(x -> System.out.print(x + " "));
    }



    private static Predicate<String> generateFilter(String filterString) {
        String[] tokens = filterString.split(";");
        String filterType = tokens[0];
        String filterArg = tokens[1];
        switch (filterType) {
            case "Starts with":
                return x -> x.startsWith(filterArg);
            case "Ends with":
                return x -> x.endsWith(filterArg);
            case "Contains":
                return x -> x.contains(filterArg);
            case "Length":
                return x -> x.length() == Integer.parseInt(filterArg);
            default:
                return x -> false;
        }
    }
}
