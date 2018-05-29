import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_Supplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int linesCount = 0;
        List<String> crates = new ArrayList<>();
        while (!"Collect".equals(input)) {
            linesCount++;
            Pattern pattern = Pattern.compile("\\[.*?]");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                crates.add(matcher.group());
            }
            input = reader.readLine();
        }
        int countCrates = 0;
        int food = 0;
        int drinks = 0;
        int validNum = crates.size() / linesCount;
        Pattern pattern = Pattern.compile(
                "\\[(?<supply>(#\\d{" + validNum + "}|#[a-z]{" + validNum + "}))(?<body>[a-zA-Z0-9\\s]*)\\1]");
        for (String crate : crates) {
            Matcher matcher = pattern.matcher(crate);
            if (matcher.matches()) {
                countCrates++;
                String supplyTag = matcher.group("supply");
                String body = matcher.group("body");
                if (Character.isDigit(supplyTag.charAt(1))) {
                    Set<Character> chars = new HashSet<>();
                    for (int i = 0; i < body.length(); i++) {
                        chars.add(body.charAt(i));
                    }
                    int sumBodyAscii = 0;
                    for (char ch : chars){
                        sumBodyAscii += ch;
                    }
                    food += sumBodyAscii * (supplyTag.length() - 1);
                } else {
                    int sumSupplyAscii = 0;
                    int sumBodyAscii = 0;
                    for (int i = 1; i < supplyTag.length(); i++) {
                        sumSupplyAscii += supplyTag.charAt(i);
                    }
                    for (char ch : body.toCharArray()){
                        sumBodyAscii += ch;
                    }
                    drinks += sumBodyAscii * sumSupplyAscii;
                }
            }
        }
        if (countCrates == 0) {
            System.out.println("No supplies found!");
        } else {
            System.out.printf("Number of supply crates: %d%n", countCrates);
            System.out.printf("Amount of food collected: %d%n", food);
            System.out.printf("Amount of drinks collected: %d%n", drinks);
        }
    }
}
