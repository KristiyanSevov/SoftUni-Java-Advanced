import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex5_SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");

//        //the lazy way
//        int sum = Integer.parseInt(inputs[0]);
//        for (int i = 1; i < inputs.length; i += 2) {
//            String operator = inputs[i];
//            int operand = Integer.parseInt(inputs[i + 1]);
//            if (operator.equals("+")) {
//                sum += operand;
//            } else {
//                sum -= operand;
//            }
//        }
//        System.out.println(sum);

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = inputs.length - 1; i >= 0 ; i--) {
            stack.push(inputs[i]);
        }
        while (stack.size() > 1) {
            int leftOperand = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());
            int result = operand.equals("+") ? leftOperand + rightOperand : leftOperand - rightOperand;
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
