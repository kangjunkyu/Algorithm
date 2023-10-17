import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class human {
		public human(int x, int y, int cnt, boolean boom) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.boom = boom;
		}

		int x;
		int y;
		int cnt;
		boolean boom;

	}

	static int N, M;
	static int[][] map;
	static boolean[][][] check;
	static Queue<human> que = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		bfs(0, 0, 1, false);
	}

	private static void bfs(int i, int j, int k, boolean b) {

		que.add(new human(i, j, k, b));

		check = new boolean[N][M][2];
		while (!que.isEmpty()) {
			human now = que.poll();
			if(now.x == N-1 && now.y == M-1) {
				System.out.println(now.cnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				int nc = now.cnt + 1;

				if (map[nx][ny] == 0) {
					if (!now.boom && !check[nx][ny][0]) {
						que.add(new human(nx, ny, nc, false));
						check[nx][ny][0] = true;
					} else if (now.boom && !check[nx][ny][1]) {
						que.add(new human(nx, ny, nc, true));
						check[nx][ny][1] = true;
					}
				}else if(map[nx][ny] == 1) {
					if(!now.boom) {
						que.add(new human(nx,ny,nc,true));
						check[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}