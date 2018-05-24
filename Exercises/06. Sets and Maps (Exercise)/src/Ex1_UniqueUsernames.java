import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex1_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> names = new LinkedHashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            names.add(reader.readLine());
        }
        names.forEach(System.out::println);
    }
}
