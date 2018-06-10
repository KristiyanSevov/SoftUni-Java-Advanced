import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> organisms = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)$");
        String input = reader.readLine();
        while (!"Stop!".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1).replaceAll("[!@#$?]", "");
                int nameLength = Integer.parseInt(matcher.group(2));
                int geneCount = Integer.parseInt(matcher.group(3));
                String organism = matcher.group(4);
                if (name.length() == nameLength) {
                    organisms.putIfAbsent(organism, 0);
                    organisms.put(organism, organisms.get(organism) + geneCount);
                }
            }
            input = reader.readLine();
        }
        organisms.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(x -> System.out.printf("%s has genome size of %d%n", x.getKey(), x.getValue()));
    }
}
