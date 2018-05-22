import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex1_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> carNumbers = new HashSet<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split(", ");
            String command = inputs[0];
            String carNumber = inputs[1];
            if ("IN".equals(command)) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }
            input = reader.readLine();
        }
        carNumbers.forEach(System.out::println);
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
    }
}
