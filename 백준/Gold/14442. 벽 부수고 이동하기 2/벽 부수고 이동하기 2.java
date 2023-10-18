import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class human {
		public human(int x, int y, int wallcnt, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.wallcnt = wallcnt;
			this.cnt = cnt;
		}

		int x;
		int y;
		int wallcnt;
		int cnt;

	}

	static int N, M, K;
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
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0, 0, 1);
	}

	private static void bfs(int x, int y, int wallcnt, int cnt) {

		que.add(new human(x, y, wallcnt, cnt));
		// 방문 배열을 3차원으로 만들어 체크한다.
		// 0일때의 불린과 1일 때의 불린을 만들어야지
		check = new boolean[N][M][K+1];
		check[x][y][0] = true;
	    while (!que.isEmpty()) {
	        human now = que.poll();
	        if (now.x == N - 1 && now.y == M - 1) {
	            System.out.println(now.cnt);
	            return;
	        }

	        for (int d = 0; d < 4; d++) {
	            int nx = now.x + dr[d];
	            int ny = now.y + dc[d];

	            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
	                continue;
	            }
				// 카운트는 천천히 1씩 더해줭
				int nc = now.cnt + 1;

				// 방문한 곳이 벽이 아니라면? 또 부신 적이 없었다면?
				if (map[nx][ny] == 0 && !check[nx][ny][now.wallcnt]) {
					// 만약 부신 적도 없었다면 현재 설정을 가지고 이동한다.
					que.add(new human(nx, ny, now.wallcnt, nc));
					// 하지만 방문 체크는 해야죠?
					check[nx][ny][now.wallcnt] = true;

					// 어라 부신 적이 있네?
				} else if (map[nx][ny] == 1 && now.wallcnt < K && !check[nx][ny][now.wallcnt + 1]) {
					// 그래도 방문 체크 해주고 true값을 가진채로 넘겨준다.
					que.add(new human(nx, ny, now.wallcnt + 1, nc));
					check[nx][ny][now.wallcnt + 1] = true;
				}

				// 벽을 만났네?
			}

		}
		System.out.println(-1);
	}
}