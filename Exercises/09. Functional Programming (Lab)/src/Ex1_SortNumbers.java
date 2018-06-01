import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ex1_SortNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder evenNums = new StringBuilder();
        StringBuilder sortedNums = new StringBuilder();
        Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .peek(x -> evenNums.append(x).append(", "))
                .sorted(Comparator.naturalOrder())
                .forEach(x -> sortedNums.append(x).append(", "));
        if (evenNums.length() != 0) {
            System.out.println(evenNums.deleteCharAt(evenNums.length() - 2));
            System.out.println(sortedNums.deleteCharAt(sortedNums.length() - 2));
        }
    }
}
