import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] check;
	static LinkedList<Block> list = new LinkedList<>();
	static Queue<Pos> que = new LinkedList<Pos>();
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Block implements Comparable<Block> {
		public Block(int total, int rainbow, int x, int y) {
			super();
			this.total = total;
			this.rainbow = rainbow;
			this.x = x;
			this.y = y;
		}

		int total;
		int rainbow;
		int x;
		int y;

		@Override
		public int compareTo(Block o) {
			if (this.total == o.total) {
				if (this.rainbow == o.rainbow) {
					if (this.x == o.x) {
						return o.y - this.y;
					}
					return o.x - this.x;
				}
				return o.rainbow - this.rainbow;
			}
			return o.total - this.total;
		}
	}

	static class Pos {
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 종료;

		while (true) {
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !check[i][j]) {
						bfs(i, j, true);
					}
				}
			}
			if (list.isEmpty()) {
				break;
			}

			Collections.sort(list);

			check = new boolean[N][N];

			bfs(list.get(0).x, list.get(0).y, false);

			boom();

			gravity();

			map = rerotate();

			gravity();

			list.clear();

		}
		System.out.println(ans);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + "");
//			}
//			System.out.println();
//		}
	}

	static int[][] rerotate() {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[N - j - 1][i] = map[i][j];
			}
		}
		return temp;
		
	}

	static void gravity() {
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				for (int k = j; k < N - 1; k++) {
					if (map[k][i] == -1) {
						continue;
					}
					if (map[k][i] != -2 && map[k + 1][i] == -2) {
						int temp = map[k][i];
						map[k][i] = -2;
						map[k + 1][i] = temp;
					}
				}
			}
		}
	}

	static void boom() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					count++;
					map[i][j] = -2;
				}
			}
		}
		ans += Math.pow(count, 2);
	}

	static void bfs(int x, int y, boolean ok) {
		int whatablock = map[x][y];
		check[x][y] = true;
		que.offer(new Pos(x, y));
		int totalPoint = 1;
		int rainbow = 0;

		while (!que.isEmpty()) {
			Pos now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (check[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == whatablock || map[nx][ny] == 0) {
					if (map[nx][ny] == 0) {
						rainbow += 1;
					}
					totalPoint += 1;
					check[nx][ny] = true;
					que.add(new Pos(nx, ny));
				}
			}
		}

		if (totalPoint >= 2) {
			list.add(new Block(totalPoint, rainbow, x, y));
		}
		if (ok) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						check[i][j] = false;
					}
				}
			}
		}
	}
}