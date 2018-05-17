import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12_VehiclePark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] vehicles = reader.readLine().split("\\s+");
        boolean[] sold = new boolean[vehicles.length];
        String input = reader.readLine();
        int soldCount = 0;
        while (!input.equals("End of customers!")) {
            String[] inputs = input.split("\\s+");
            char vehicleType = inputs[0].toLowerCase().charAt(0);
            int seats = Integer.parseInt(inputs[2]);
            String vehicle = vehicleType + inputs[2];
            boolean found = false;
            for (int i = 0; i < vehicles.length; i++) {
                if (vehicle.equals(vehicles[i]) && !sold[i]) {
                    sold[i] = true;
                    int price = vehicleType * seats;
                    System.out.printf("Yes, sold for %d$%n", price);
                    found = true;
                    soldCount++;
                    break;
                }
            }
            if (!found) {
                System.out.println("No");
            }
            input = reader.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vehicles.length; i++) {
            if (!sold[i]) {
                sb.append(vehicles[i]);
                sb.append(", ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 2);
        }
        System.out.println("Vehicles left: " + sb.toString());
        System.out.printf("Vehicles sold: %d", soldCount);
    }
}
