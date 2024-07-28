import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int dp[][];
	static int square[][];
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		square = new int[N + 1][M + 1];
		max = 0;

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				square[i][j] = str.charAt(j-1) - '0';
			}
		}
		checkSquare(square);

		System.out.println((int)Math.pow(max, 2));

	}

	private static void checkSquare(int[][] square) {
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (square[i][j] == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}

	}
}