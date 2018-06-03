import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class Ex13_InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] items = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<String> filterStrings = new HashSet<>();
        String input = reader.readLine();
        while (!"Forge".equals(input)) {
            String[] inputs = input.split(";", 2);
            String command = inputs[0];
            String filterString = inputs[1];
            if ("Exclude".equals(command)) {
                filterStrings.add(filterString);
            } else if ("Reverse".equals(command)){
                filterStrings.remove(filterString);
            }
            input = reader.readLine();
        }

        Predicate<Integer> combinedFilter = index -> {
            for (String filterString : filterStrings) {
                if (generateFilter(filterString, items).test(index)) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 0; i < items.length; i++) {
            if (combinedFilter.test(i)) {
                System.out.print(items[i] + " ");
            }
        }
    }

    private static Predicate<Integer> generateFilter(String filterString, int[] items) {
        String[] tokens = filterString.split(";");
        String filterType = tokens[0];
        int filterArg = Integer.parseInt(tokens[1]);
        return index -> {
            int leftItem = index != 0 ? items[index - 1] : 0;
            int rightItem = index != items.length - 1 ? items[index + 1] : 0;
            switch (filterType) {
                case "Sum Left":
                    return leftItem + items[index] == filterArg;
                case "Sum Right":
                    return items[index] + rightItem == filterArg;
                case "Sum Left Right":
                    return leftItem + items[index] + rightItem == filterArg;
                default:
                    return false;
            }
        };
    }
}
