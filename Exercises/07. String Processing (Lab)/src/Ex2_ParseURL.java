import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2_ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("://");
        if (inputs.length != 2) {
            System.out.println("Invalid URL");
            return;
        }
        System.out.println("Protocol = " + inputs[0]);
        System.out.println("Server = " + inputs[1].substring(0, inputs[1].indexOf('/')));
        System.out.println("Resources = " + inputs[1].substring(inputs[1].indexOf('/') + 1));
    }
}
