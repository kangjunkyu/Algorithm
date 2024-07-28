import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static int[][] map, dp;
	static int[] searchX = { 0, 0, -1, 1 };
	static int[] searchY = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N ];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 가장길게 생존가능한 시간을 나타내라
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}

	private static int dfs(int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		} else {
			// 처음 시작할 때 dp[x][y] 가 0이라면 최소 1년은 살 수 있다.
			dp[x][y] = 1;
			//완탐
			for (int i = 0; i < 4; i++) {
				int nx = x + searchX[i];
				int ny = y + searchY[i];

				// 범위 확인
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				} else {
					// 다음 공간이 더 많은 곳이 있나 봐라
					if (map[nx][ny] > map[x][y]) {
						// 그럼 비교를 해서 넣어줘, 현재 위치와 다음 dfs 조건(nx, ny에서 판다가 생존 가능한 시간)에 대한 값으로
						dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
					}
				}
			}
			return dp[x][y];
		}
	}
}