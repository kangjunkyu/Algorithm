import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] board;
	static int n, m;
	static int cheese;

	static class air {
		public air(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		cheese = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					cheese++;
			}
		}

		int cheeseCount = 0;
		int time = 0;
		
		while (cheese != 0) {
			cheeseCount = cheese;
			time++;
			visited = new boolean[n][m];
			bfs();
		}
		System.out.println(time);
		System.out.println(cheeseCount);
	}

	public static void bfs() {
		Queue<air> q = new LinkedList<>();
		q.offer(new air(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			air now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					if (board[nx][ny] == 0) {
						q.offer(new air(nx, ny));
					} else {
						cheese--;
						board[nx][ny] = 0;
					}
				}
			}
		}
	}
}