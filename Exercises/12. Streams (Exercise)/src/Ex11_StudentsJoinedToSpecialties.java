import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        String input = reader.readLine();
        while (!"Students:".equals(input)) {
            String[] inputs = input.split("\\s+");
            String specialty = inputs[0] + " " + inputs[1];
            String facultyNumber = inputs[2];
            studentSpecialties.add(new StudentSpecialty(specialty, facultyNumber));
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split("\\s+", 2);
            String facultyNumber = inputs[0];
            String name = inputs[1];
            students.add(new Student(name, facultyNumber));
            input = reader.readLine();
        }
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(x -> studentSpecialties.stream()
                        .filter(s -> s.getFacultyNumber().equals(x.getFacultyNumber()))
                        .forEach(s -> System.out.printf("%s %s %s%n", x.getName(), x.getFacultyNumber(), s.getName())));
    }
}

class StudentSpecialty {
    private String name;
    private String facultyNumber;

    public StudentSpecialty(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}

class Student {
    private String name;
    private String facultyNumber;

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}

