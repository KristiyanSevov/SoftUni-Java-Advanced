import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex2_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        Set<String> results = new LinkedHashSet<>();
        String[] inputs = reader.readLine().split(" ");
        int firstCount = Integer.parseInt(inputs[0]);
        int secondCount = Integer.parseInt(inputs[1]);
        for (int i = 0; i < firstCount; i++) {
            firstSet.add(reader.readLine());
        }
        for (int i = 0; i < secondCount; i++) {
            secondSet.add(reader.readLine());
        }
        for (String s : firstSet){
            if (secondSet.contains(s)) {
                results.add(s);
            }
        }
        results.forEach(x -> System.out.print(x + " "));
    }
}
