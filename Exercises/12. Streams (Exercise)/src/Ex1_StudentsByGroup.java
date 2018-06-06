import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex1_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)){
            data.add(input);
            input = reader.readLine();
        }
        //the lazy way
        data.stream() //input example: Andrew Carter 2
                .map(x -> x.split(" "))
                .filter(x -> x[2].equals("2"))
                .sorted(Comparator.comparing(x -> x[0]))
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
