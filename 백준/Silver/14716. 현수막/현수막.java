import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = { 0, 0, 1, -1, -1, 1, 1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println(Arrays.deepToString(map));

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j] && map[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int i, int j) {
		if (!check[i][j]) {
			check[i][j] = true;
			for (int d = 0; d < 8; d++) {

				int nx = i + dr[d];
				int ny = j + dc[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (check[nx][ny] || map[nx][ny] != 1) {
					continue;
				}
				dfs(nx, ny);
			}
		}
	}
}