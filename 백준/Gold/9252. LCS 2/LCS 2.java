import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	static int len1, len2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		len1 = str1.length;
		len2 = str2.length;

		dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		solve(str1);
		System.out.println(dp[len1][len2]);
		System.out.println(sb);

	}

	private static void solve(char[] str) {
		Stack<Character> stack = new Stack<>();
		int num1 = len1;
		int num2 = len2;

		while (num1 > 0 && num2 > 0) {
			if (dp[num1][num2] == dp[num1 - 1][num2]) {
				num1--;
			} else if (dp[num1][num2] == dp[num1][num2 - 1]) {
				num2--;
			} else {
				stack.push(str[num1 - 1]);
				num1--;
				num2--;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}

}