import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Spin {
		public Spin(int time, String dir) {
			super();
			this.time = time;
			this.dir = dir;
		}

		int time;
		String dir;
	}

	static class Snake {
		public Snake(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;

	}

	static int N, K, L;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Spin> spin;
	static int dir, time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int applex = Integer.parseInt(st.nextToken());
			int appley = Integer.parseInt(st.nextToken());

			map[applex][appley] = 1;
		}

		L = Integer.parseInt(br.readLine());

		spin = new LinkedList<>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			spin.add(new Spin(time, dir));
		}

		solve(1, 1);

		System.out.println(time);

	}

	static void solve(int x, int y) {
		time = 0;
		dir = 1;

		Queue<Snake> que = new LinkedList<>();

		que.offer(new Snake(x, y));
		map[x][y] = 2;

		while (true) {
			int nx = x + dr[dir];
			int ny = y + dc[dir];

			time++;

			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				break;
			}
			if (map[nx][ny] == 2) {
				break;
			}

			if (map[nx][ny] == 0) {
				Snake now = que.poll();
				map[now.x][now.y] = 0;
			}

			if (!spin.isEmpty()) {
				if (time == spin.peek().time) {
					Spin s = spin.poll();

					if (s.dir.equals("D")) {
						dir = dir + 1 > 3 ? 0 : dir + 1;
					}
					if (s.dir.equals("L")) {
						dir = dir - 1 < 0 ? 3 : dir - 1;
					}
				}
			}

			map[nx][ny] = 2;
			que.offer(new Snake(nx, ny));
			x = nx;
			y = ny;
		}
	}
}