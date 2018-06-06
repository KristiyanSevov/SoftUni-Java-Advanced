import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex5_FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            data.add(input);
            input = reader.readLine();
        }
        data.stream() //input example: Andrew Carter xxx@gmail.com
                .map(x -> x.split(" "))
                .filter(x -> x[2].endsWith("@gmail.com"))
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
