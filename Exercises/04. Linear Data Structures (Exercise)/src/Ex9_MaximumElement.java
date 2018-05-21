import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex9_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String command = inputs[0];
            switch (command) {
                case "1":
                    int elem = Integer.parseInt(inputs[1]);
                    stack.push(elem);
                    if (maxStack.isEmpty() || elem > maxStack.peek()) {
                        maxStack.push(elem);
                    }
                    break;
                case "2":
                    if(stack.pop().equals(maxStack.peek())){
                        maxStack.pop();
                    }
                    break;
                case "3":
                    sb.append(maxStack.peek()).append(System.lineSeparator());
                    break;
            }
        }
        System.out.print(sb);
    }

//    //the other way
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        StringBuilder sb = new StringBuilder();
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            String[] inputs = reader.readLine().split(" ");
//            String command = inputs[0];
//            switch (command) {
//                case "1":
//                    int elem = Integer.parseInt(inputs[1]);
//                    stack.push(elem);
//                    if (elem > max) {
//                        max = elem;
//                    }
//                    break;
//                case "2":
//                    if(stack.pop() == max){
//                        max = Integer.MIN_VALUE;
//                        for (int num : stack) {
//                            if (num > max) {
//                                max = num;
//                            }
//                        }
//                    }
//                    break;
//                case "3":
//                    sb.append(max);
//                    sb.append("\n");
//                    break;
//            }
//        }
//        System.out.print(sb);
//    }
}
