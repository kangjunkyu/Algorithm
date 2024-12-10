import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int[][] dp = new int[10001][4];

			dp[1][1] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			dp[3][1] = 1;
			dp[3][2] = 1;
			dp[3][3] = 1;

			for (int i = 4; i <= 10000; i++) {
				dp[i][1] = dp[i - 1][1];
				dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
				dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
			}
			
			int ans = Integer.parseInt(br.readLine());
			
			int result = dp[ans][1] + dp[ans][2] + dp[ans][3];
			
			System.out.println(result);
		}
	}
}