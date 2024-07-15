import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pass = "";

        while (!(pass = br.readLine()).equals("end")) {
            char[] word = pass.toCharArray();
            boolean hasVowel = false;
            boolean isAcceptable = true;
            int vowelStreak = 0;
            int consonantStreak = 0;
            char prevChar = '*';

            for (char ch : word) {
                if (isVowel(ch)) {
                    hasVowel = true;
                    vowelStreak++;
                    consonantStreak = 0;
                } else {
                    consonantStreak++;
                    vowelStreak = 0;
                }

                if (vowelStreak > 2 || consonantStreak > 2) {
                    isAcceptable = false;
                    break;
                }

                if (ch == prevChar && (ch != 'e' && ch != 'o')) {
                    isAcceptable = false;
                    break;
                }

                prevChar = ch;
            }

            if (hasVowel && isAcceptable) {
                System.out.println("<" + pass + "> is acceptable.");
            } else {
                System.out.println("<" + pass + "> is not acceptable.");
            }
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}