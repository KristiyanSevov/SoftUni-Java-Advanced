import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex9_ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(reader.readLine()));
        }
        String input = reader.readLine();
        while (!input.equals("party over")) {
            String[] inputs = input.split("\\s+");
            String command = inputs[0];
            int bitPosition = Integer.parseInt(inputs[1]);
            for (int i = 0; i < nums.size(); i++) {
                switch (command){
                    case "-1":
                        nums.set(i, flip(nums.get(i), bitPosition));
                        break;
                    case "0":
                        nums.set(i, unset(nums.get(i), bitPosition));
                        break;
                    case "1":
                        nums.set(i, set(nums.get(i), bitPosition));
                        break;
                }
            }
            input = reader.readLine();
        }
        nums.forEach(x -> System.out.println(x + " "));
    }

    private static int flip(int num, int bitPosition) {
        return (1 << bitPosition) ^ num;
    }

    private static int unset(int num, int bitPosition) {
        return (~(1 << bitPosition)) & num;
    }

    private static int set(int num, int bitPosition) {
        return (1 << bitPosition) | num;
    }
}

