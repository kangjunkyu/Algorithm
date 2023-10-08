import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Land {
		int x;
		int y;
		int cnt;

		public Land(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] check;
	static int landNum = 2;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int min = Integer.MAX_VALUE - 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					makeland(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2) {
					check = new boolean[N][N];
					bfs(i, j);
				}
			}
		}
		System.out.println(min);
	}

	static void makeland(int x, int y) {
		Queue<Land> que = new LinkedList<Land>();
		que.add(new Land(x, y, 0));

		check[x][y] = true;
		map[x][y] = landNum;

		while (!que.isEmpty()) {
			Land now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (!check[nx][ny] && map[nx][ny] == 1) {
					check[nx][ny] = true;
					map[nx][ny] = landNum;
					que.add(new Land(nx, ny, 0));
				}
			}
		}
		landNum++;
	}

	static void bfs(int x, int y) {
		Queue<Land> que = new LinkedList<Land>();
		que.add(new Land(x, y, 0));

		int temp = map[x][y];
		check[x][y] = true;
		while (!que.isEmpty()) {
			Land now = que.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (!check[nx][ny] && map[nx][ny] != temp) {
					check[nx][ny] = true;
					if (map[nx][ny] == 0) {
						que.add(new Land(nx, ny, now.cnt + 1));
					} else {
						min = Math.min(min, now.cnt);
					}
				}
			}
		}
	}
}