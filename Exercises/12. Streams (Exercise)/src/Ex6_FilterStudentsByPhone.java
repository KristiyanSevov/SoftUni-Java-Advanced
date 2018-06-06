import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex6_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            data.add(input);
            input = reader.readLine();
        }
        data.stream() //input example: Andrew Carter +001234532
                .map(x -> x.split(" "))
                .filter(x -> x[2].matches("(02|\\+3592).*"))
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
