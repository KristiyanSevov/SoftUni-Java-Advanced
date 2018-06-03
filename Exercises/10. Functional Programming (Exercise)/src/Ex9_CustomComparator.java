import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex9_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Integer> customComparator = (x, y) -> {
            if (x % 2 == 0 && y % 2 != 0) {
                return -1;
            } else if (x % 2 != 0 && y % 2 == 0) {
                return 1;
            } else {
                return x.compareTo(y);
            }
        };

        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(x -> System.out.print(x + " "));
    }
}
