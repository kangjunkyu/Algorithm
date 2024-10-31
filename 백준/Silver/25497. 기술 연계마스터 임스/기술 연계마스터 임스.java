import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int ans = 0;
        Stack<Character> LS = new Stack<>();
        Stack<Character> SS = new Stack<>();

        for (int i = 0; i < N; i++) {
            char target = str.charAt(i);

            if (Character.isDigit(target)) {
                ans += 1;
            } else if (target == 'L') {
                LS.push(target);
            } else if (target == 'S') {
                SS.push(target);
            } else if (target == 'R') {
                if (!LS.isEmpty()) {
                    LS.pop();
                    ans += 1;
                } else {
                    break;
                }
            } else if (target == 'K') {
                if (!SS.isEmpty()) {
                    SS.pop();
                    ans += 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}