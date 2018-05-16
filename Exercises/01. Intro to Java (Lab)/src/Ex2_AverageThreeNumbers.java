import java.util.Locale;
import java.util.Scanner;

public class Ex2_AverageThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double first = scan.nextDouble();
        double second = scan.nextDouble();
        double third = scan.nextDouble();
        System.out.printf("%.2f", (first + second + third) / 3);
    }
}
