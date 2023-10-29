import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] check;
	static boolean pick;
	static int dx[] = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int dy[] = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j]) {
					pick = true;
					dfs(i, j);
					if (pick)
						ans++;
				}
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		check[x][y] = true;
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}
			if (map[nx][ny] > map[x][y]) {
				pick = false;
			}
			if (!check[nx][ny] && map[nx][ny] == map[x][y]) {
				dfs(nx, ny);
			}
		}
	}

}