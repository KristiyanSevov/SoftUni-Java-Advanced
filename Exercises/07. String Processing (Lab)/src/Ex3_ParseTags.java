import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3_ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        while (text.contains("<upcase>")) {
            int beginIndex = text.indexOf("<upcase>");
            int endIndex = text.indexOf("</upcase>");
            String toReplace = text.substring(beginIndex, endIndex + 9);
            String toAdd = text.substring(beginIndex + 8, endIndex).toUpperCase();
            text = text.replace(toReplace, toAdd);
        }
        System.out.println(text);
    }
}
