import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2_TriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        int ax = Integer.parseInt(inputs[0]);
        int ay = Integer.parseInt(inputs[1]);
        inputs = reader.readLine().split("\\s+");
        int bx = Integer.parseInt(inputs[0]);
        int by = Integer.parseInt(inputs[1]);
        inputs = reader.readLine().split("\\s+");
        int cx = Integer.parseInt(inputs[0]);
        int cy = Integer.parseInt(inputs[1]);
        double area = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2;
        System.out.println(Math.abs(Math.round(area)));
    }
}
