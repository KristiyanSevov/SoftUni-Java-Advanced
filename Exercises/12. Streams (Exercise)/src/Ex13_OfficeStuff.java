import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex13_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //just for fun
        IntStream.range(0, Integer.parseInt(reader.readLine()))
                .boxed()
                .map(x -> {
                    try { return reader.readLine(); }
                    catch (IOException e) { return ""; }
                })
                .map(x -> Arrays.stream(x.split("[| -]+"))
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList()))
                .collect(Collectors.groupingBy(x -> x.get(0)))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> System.out.printf("%s: %s%n",
                        x.getKey(), String.join(", ", x.getValue()
                                .stream()
                                .collect(Collectors.groupingBy(y -> y.get(2), LinkedHashMap::new, Collectors.toList()))
                                .entrySet()
                                .stream()
                                .map(s -> String.format("%s-%s", s.getKey(), s.getValue().stream()
                                        .mapToInt(ls -> Integer.parseInt(ls.get(1)))
                                        .sum()))
                                .collect(Collectors.toList()))));
    }
}