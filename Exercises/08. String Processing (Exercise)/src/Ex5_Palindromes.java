import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex5_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split("[., !?]"))
                .filter(x -> !x.isEmpty() && isPal(x))
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList()));
    }

    private static boolean isPal(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
