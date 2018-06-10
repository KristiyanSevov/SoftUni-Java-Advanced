import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class Ex1_Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> problemStack = new ArrayDeque<>();
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        for (int i = 0; i < x; i++) {
            String problem = reader.readLine();
            problemStack.push(problem);
        }
        for (int i = 0; i < y; i++) {
            String candidate = reader.readLine();
            if (candidate.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                candidatesQueue.offer(candidate);
            }
        }
        while (!problemStack.isEmpty() && !candidatesQueue.isEmpty()) {
            if (candidatesQueue.size() == 1) {
                System.out.println(candidatesQueue.poll() + " gets the job!");
                return;
            }
            String candidate = candidatesQueue.poll();
            String problem = problemStack.pop();
            int sumCandidate = 0;
            for (int i = 0; i < candidate.length(); i++) {
                sumCandidate += candidate.charAt(i);
            }
            int sumProblem = 0;
            for (int i = 0; i < problem.length(); i++) {
                sumProblem += problem.charAt(i);
            }
            if (sumCandidate > sumProblem) {
                System.out.printf("%s solved %s.%n", candidate, problem);
                candidatesQueue.offer(candidate);
            } else {
                System.out.printf("%s failed %s.%n", candidate, problem);
                problemStack.addLast(problem);
            }
        }
        System.out.println(String.join(", ", candidatesQueue));
    }
}
