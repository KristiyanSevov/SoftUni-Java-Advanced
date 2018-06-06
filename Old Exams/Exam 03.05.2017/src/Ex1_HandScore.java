import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex1_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> values = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            values.put((char) (i + '0'), i);
        }
        values.put('J', 12);
        values.put('Q', 13);
        values.put('K', 14);
        values.put('A', 15);
        int totalSum = 0;
        char oldSuit = '-';
        int currentSum = 0;
        int countEqualSuits = 1;
        String[] cards = reader.readLine().split(" ");
        for (String card : cards) {
            int cardValue = card.length() == 3 ? 10 : values.get(card.charAt(0));
            char suit = card.length() == 3 ? card.charAt(2) : card.charAt(1);
            if (suit == oldSuit) {
                currentSum += cardValue;
                countEqualSuits++;
            } else {
                totalSum += currentSum * countEqualSuits;
                countEqualSuits = 1;
                oldSuit = suit;
                currentSum = cardValue;
            }
        }
        totalSum += currentSum * countEqualSuits;
        System.out.println(totalSum);
    }
}
