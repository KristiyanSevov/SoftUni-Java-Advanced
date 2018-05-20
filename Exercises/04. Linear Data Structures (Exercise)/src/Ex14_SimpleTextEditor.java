import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Ex14_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> text = new ArrayList<>();
        ArrayDeque<List<Character>> stack = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String command = inputs[0];
            switch (command) {
                case "1":
                    String addedStr = inputs[1];
                    for (int j = 0; j < addedStr.length(); j++) {
                        text.add(addedStr.charAt(j));
                    }
                    stack.push(new ArrayList<>(text));
                    break;
                case "2":
                    int count = Integer.parseInt(inputs[1]);
                    for (int j = 0; j < count; j++) {
                        text.remove(text.size() - 1);
                    }
                    stack.push(new ArrayList<>(text));
                    break;
                case "3":
                    int index = Integer.parseInt(inputs[1]) - 1;
                    System.out.println(text.get(index));
                    break;
                case "4":
                    stack.pop();
                    text = stack.isEmpty() ? new ArrayList<>() : stack.peek();
                    break;
            }
        }
    }
}
