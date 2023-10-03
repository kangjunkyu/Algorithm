import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] subject = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			subject[i][0] = Integer.parseInt(st.nextToken());
			subject[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][T + 1];



		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= T; j++) {
				dp[i][j] = dp[i - 1][j];

				if (j - subject[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - subject[i][0]] + subject[i][1]);
				}
			}
		}
		System.out.println(dp[N][T]);
	}
}