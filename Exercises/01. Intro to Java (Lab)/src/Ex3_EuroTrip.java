import java.math.BigDecimal;
        import java.util.Scanner;

public class Ex3_EuroTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double wurst = scan.nextDouble();
        BigDecimal total = new BigDecimal(wurst * 1.2).multiply(new BigDecimal("4210500000000"));
        System.out.printf("%.2f marks", total);
    }
}
