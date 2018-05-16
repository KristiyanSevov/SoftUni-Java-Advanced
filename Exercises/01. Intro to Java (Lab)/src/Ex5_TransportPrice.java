import java.math.BigDecimal;
import java.util.Scanner;

public class Ex5_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        BigDecimal result;
        if (distance < 20) {
            BigDecimal cost = BigDecimal.valueOf("day".equals(type) ? 0.79 : 0.9);
            result = BigDecimal.valueOf(0.7).add(cost.multiply(BigDecimal.valueOf(distance)));
        } else if (distance < 100){
            result = BigDecimal.valueOf(0.09).multiply(BigDecimal.valueOf(distance));
        } else {
            result = BigDecimal.valueOf(0.06).multiply(BigDecimal.valueOf(distance));
        }
        System.out.printf("%.2f", result);
    }
}
