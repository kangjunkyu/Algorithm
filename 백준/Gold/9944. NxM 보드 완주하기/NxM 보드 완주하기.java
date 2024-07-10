import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, num, min;
	static char[][] map;
	static boolean[][] check;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";
		num = 0;
		int T = 1;

		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			num = 0;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '.') {
						num++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				check = new boolean[N][M];
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '.') {
						for (int d = 0; d < 4; d++) {
							check[i][j] = true;
							dfs(i, j, d, 1, 1);
							check[i][j] = false;

						}
					}
				}
			}

			if (num == 1) {
				System.out.println("Case " + T + ": 0");
			} else {
				if (min == Integer.MAX_VALUE) {
					System.out.println("Case " + T + ": -1");
				} else {
					System.out.println("Case " + T + ": " + min);
				}
			}
			T++;
		}

	}

	private static void dfs(int r, int c, int dir, int cnt, int depth) {
		if (num == depth) {
			if (min > cnt) {
				min = cnt;
			}
			return;
		}

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '.' || check[nr][nc]) {
			for (int nd = 0; nd < 4; nd++) {
				int nnr = r + dr[nd];
				int nnc = c + dc[nd];
				if (nnr >= 0 && nnr < N && nnc >= 0 && nnc < M && map[nnr][nnc] == '.' && !check[nnr][nnc]) {
					check[nnr][nnc] = true;
					dfs(nnr, nnc, nd, cnt + 1, depth + 1);
					check[nnr][nnc] = false;
				}
			}
		} else {

			check[nr][nc] = true;
			dfs(nr, nc, dir, cnt, depth + 1);
			check[nr][nc] = false;
		}

	}
}