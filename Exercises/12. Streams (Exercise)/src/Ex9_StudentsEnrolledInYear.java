import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex9_StudentsEnrolledInYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            data.add(input);
            input = reader.readLine();
        }
        data.stream() //input example: 554214 6 6 6 5
                .map(x -> x.split(" ", 2))
                .filter(x -> x[0].endsWith("14") || x[0].endsWith("15"))
                .forEach(x -> System.out.println(x[1]));
    }
}
