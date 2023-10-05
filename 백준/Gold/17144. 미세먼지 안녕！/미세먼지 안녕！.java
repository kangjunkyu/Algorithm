import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int airFilter = -1;
	static Queue<dust> dusts;

	static class dust {
		int x;
		int y;
		int w;

		public dust(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (airFilter == -1 && map[i][j] == -1) {
					airFilter = i;
				}
			}
		}

		for (int time = 0; time < T; time++) {

			checkDust();

			circle();
			
			operate();
		}

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0) {
					continue;
				} else {
					cnt += map[i][j];

				}
			}
		}
		System.out.println(cnt);
//
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static void checkDust() {

		dusts = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				if (map[i][j] == -1 || map[i][j] == 0) {
//					continue;
//				}
				if (map[i][j] <= 0) {
					continue;
				}
				dusts.add(new dust(i, j, map[i][j]));
			}
		}
	}

	static void circle() {
		int map2[][] = new int[R][C];

		while (!dusts.isEmpty()) {

			dust now = dusts.poll();

			if (now.w < 5)
				continue;

			int amount = now.w / 5;
			int count = 0;

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) {
					continue;
				}
				map[nx][ny] += amount;
				++count;
			}
			map[now.x][now.y] -= amount * count;
		}
	}

	static void operate() {
		int top = airFilter;
		int down = airFilter + 1;

		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for (int i = C-1; i > 0; i--) {
			map[top][i] = map[top][i-1];
		}
		map[top][1] = 0;
		
		for (int i = down + 1; i < R-1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[R-1][i] = map[R-1][i + 1];
		}
		for (int i = R-1; i > down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			map[down][i] = map[down][i-1];
		}
		map[down][1] = 0;
	}
}