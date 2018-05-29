import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1_StudentResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" - ");
        String name = inputs[0];
        List<Double> grades = new ArrayList<>();
        for (String num : inputs[1].split(", ")) {
            grades.add(Double.parseDouble(num));
        }
        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", name, grades.get(0), grades.get(1), grades.get(2),
                grades.stream().mapToDouble(Double::valueOf).average().getAsDouble());
    }
}
