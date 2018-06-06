import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex7_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            data.add(input);
            input = reader.readLine();
        }
        data.stream() //input example: Andrew Carter 2 3 4 6
                .map(x -> x.split(" ", 3))
                .filter(x -> x[2].contains("6"))
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
