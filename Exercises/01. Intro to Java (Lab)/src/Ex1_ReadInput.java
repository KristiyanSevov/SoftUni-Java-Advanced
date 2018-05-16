import java.util.Scanner;

public class Ex1_ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.next("\\w+");
        String second = scan.next("\\w+");
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        scan.nextLine();
        String last = scan.nextLine();
        System.out.printf("%s %s %s %d", first, second, last, x + y + z);
    }
}
