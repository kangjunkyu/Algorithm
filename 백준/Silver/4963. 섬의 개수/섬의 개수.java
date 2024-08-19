import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 };
	static int[][] map;
	static boolean[][] check;
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			check = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
						ans++;
					}
				}
			}

			System.out.println(ans);
		}
	}

	private static void dfs(int i, int j) {
		check[i][j] = true;

		for (int k = 0; k < 8; k++) {
			int newX = i + dx[k];
			int newY = j + dy[k];

			if (newX < 0 || newX >= h || newY < 0 || newY >= w) {
				continue;
			}
			if (!check[newX][newY] && map[newX][newY] == 1) {
				dfs(newX, newY);
			}
		}
	}
}