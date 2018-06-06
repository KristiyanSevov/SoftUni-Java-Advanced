import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split(" ");
            String name = inputs[0] + " " + inputs[1];
            int group = Integer.parseInt(inputs[2]);
            people.add(new Person(name, group));
            input = reader.readLine();
        }
        people.stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((key, value) -> System.out.printf("%s - %s%n", key,
                        value.stream().map(Person::getName).collect(Collectors.joining(", "))));
    }
}


class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }
}
