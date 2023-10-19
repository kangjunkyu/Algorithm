import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE - 1;

			}
		} 

		dp[1][1] = 0;

		int updown = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != N) {
					if (map[i + 1][j] >= map[i][j]) {
						updown = map[i + 1][j] - map[i][j] + 1;
						dp[i + 1][j] = Math.min(dp[i + 1][j], updown + dp[i][j]);
					} 
					else {
						dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
					}
				}if (j != N) {
					if (map[i][j + 1] >= map[i][j]) {
						updown = map[i][j + 1] - map[i][j] + 1;
						dp[i][j + 1] = Math.min(dp[i][j + 1], updown + dp[i][j]);
					} 
					else {
						dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
					}
				}
				if (i == N && j == N) {
					break;
				}
			}
		}
		System.out.println(dp[N][N]);
	}
}