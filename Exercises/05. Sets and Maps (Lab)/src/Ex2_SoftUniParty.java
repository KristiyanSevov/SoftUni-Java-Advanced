import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Ex2_SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> tickets = new TreeSet<>();
        String input = reader.readLine();
        while (!"PARTY".equals(input)) {
            tickets.add(input);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!"END".equals(input)) {
            tickets.remove(input);
            input = reader.readLine();
        }
        System.out.println(tickets.size());
        tickets.forEach(System.out::println);
    }
}
