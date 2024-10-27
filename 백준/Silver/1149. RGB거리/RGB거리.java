import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R = 0;
	static int G = 1;
	static int B = 2;

	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		map = new int[N][3];
		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][R] = Integer.parseInt(st.nextToken());
			map[i][G] = Integer.parseInt(st.nextToken());
			map[i][B] = Integer.parseInt(st.nextToken());
		}

		dp[0][R] = map[0][R];
		dp[0][G] = map[0][G];
		dp[0][B] = map[0][B];

		int R_res = Cal(N-1, R);
		int G_res = Cal(N-1, G);
		int B_res = Cal(N-1, B);
		
		int ans = Math.min(R_res, Math.min(G_res, B_res));
		
		System.out.println(ans);

	}

	private static int Cal(int n, int color) {

		if (dp[n][color] == 0) {

			if (color == R) {
				dp[n][color] = Math.min(Cal(n - 1, G), Cal(n - 1, B)) + map[n][R];
			} else if (color == G) {
				dp[n][color] = Math.min(Cal(n - 1, R), Cal(n - 1, B)) + map[n][G];
			} else {
				dp[n][color] = Math.min(Cal(n - 1, G), Cal(n - 1, R)) + map[n][B];

			}
		}

		return dp[n][color];
	}
}