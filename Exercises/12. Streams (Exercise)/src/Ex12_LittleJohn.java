import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex12_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> arrowCounts = new LinkedHashMap<>();
        arrowCounts.put(">----->", 0);
        arrowCounts.put(">>----->", 0);
        arrowCounts.put(">>>----->>", 0);
        Pattern pattern = Pattern.compile("(>>>----->>|>>----->|>----->)");
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String arrow = matcher.group();
                arrowCounts.put(arrow, arrowCounts.get(arrow) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer count : arrowCounts.values()){
            sb.append(count);
        }
        int num = Integer.parseInt(sb.toString());
        String binary = Integer.toBinaryString(num);
        String reversedBinary = new StringBuilder(binary).reverse().toString();
        String finalBinary = binary + reversedBinary;
        int finalNumber = Integer.parseInt(finalBinary, 2);
        System.out.println(finalNumber);
    }
}
