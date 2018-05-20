import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex12_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else{
                switch (ch){
                    case ')':
                        if (stack.pop() != '(') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                }
            }
        }
        System.out.println("YES");
    }
}
