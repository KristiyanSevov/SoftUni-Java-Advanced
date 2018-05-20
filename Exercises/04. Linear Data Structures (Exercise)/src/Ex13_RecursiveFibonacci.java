import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex13_RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Long> results = new HashMap<>();
        System.out.println(fib(n, results));
    }

    private static long fib(int n, Map<Integer, Long> results) {
        if (n == 0 || n == 1) {
            return 1L;
        }
        if (results.containsKey(n)) {
            return results.get(n);
        } else {
            long result = fib(n - 1, results) + fib(n - 2, results);
            results.put(n, result);
            return result;
        }
    }
}
