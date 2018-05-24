import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex9_UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = reader.readLine();
        while (!"end".equals(input)) {
            String[] inputs = input.split(" ");
            String IP = inputs[0].split("=")[1];
            String user = inputs[2].split("=")[1];
            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(IP, 0);
            users.get(user).put(IP, users.get(user).get(IP) + 1);
            input = reader.readLine();
        }
        for (String user : users.keySet()) {
            System.out.println(user + ":");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> IPEntry : users.get(user).entrySet()) {
                sb.append(String.format("%s => %s, ", IPEntry.getKey(), IPEntry.getValue()));
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(".");
            System.out.println(sb);
        }
    }
}
