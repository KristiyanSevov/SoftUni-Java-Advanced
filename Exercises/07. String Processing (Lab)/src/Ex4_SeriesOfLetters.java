import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Ex4_SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.addLast(text.charAt(0));
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != deque.peekLast()) {
                deque.addLast(text.charAt(i));
            }
        }
        deque.forEach(System.out::print);
    }
}
