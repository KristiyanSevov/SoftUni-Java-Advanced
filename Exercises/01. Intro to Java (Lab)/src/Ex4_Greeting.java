import java.util.Scanner;

public class Ex4_Greeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.nextLine();
        String second = scan.nextLine();
        if (first.isEmpty()){
            first = "*****";
        }
        if (second.isEmpty()){
            second = "*****";
        }
        System.out.printf("Hello, %s %s!", first, second);
    }
}
