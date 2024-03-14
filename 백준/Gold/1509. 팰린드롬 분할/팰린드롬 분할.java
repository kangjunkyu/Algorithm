import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dp;
	static boolean[][] pal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int len = str.length();
		dp = new int[len + 1];
		pal = new boolean[len + 1][len + 1];

		for (int i = 1; i <= len; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		checkPal(str, len);

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if (pal[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
//		System.out.println(dp.toString());

		System.out.println(dp[len]);

	}

	private static void checkPal(String str, int len) {
		for (int start = 1; start <= len; start++) {
			for (int end = start; end <= len; end++) {

				boolean check = true;
				int s = start - 1;
				int e = end - 1;

				while (s <= e) {
					if (str.charAt(s++) != str.charAt(e--)) {
						check = false;
						break;
					}
				}

				if (check) {
					pal[start][end] = true;
				}
			}
		}
	}
}