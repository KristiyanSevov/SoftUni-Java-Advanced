import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex5_AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> students = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            double avg = 0;
            for (double grade : grades) {
                avg += grade;
            }
            avg /= grades.length;
            students.put(name, avg);
        }
        students.forEach((key, value) -> System.out.printf("%s is graduated with %s%n", key, value));
    }
}
