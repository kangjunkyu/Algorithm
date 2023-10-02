import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static int[][] map;
//	static boolean[][] check;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 1;
		
		dfs(r, c, d);
		System.out.println(cnt);
	}

	static void dfs(int r, int c, int d) {
		map[r][c] = -1;

		for (int dic = 0; dic < 4; dic++) {
			d = (d + 3) % 4;
			int nx = r + dr[d];
			int ny = c + dc[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) {
				continue;
			}
			if (map[nx][ny] == 0) {
				cnt++;
				dfs(nx, ny, d);
				return;
			}
		}

		int Return = (d + 2) % 4;
		int rx = r + dr[Return];
		int ry = c + dc[Return];

		if (rx >= 0 && rx < N && ry >= 0 && ry < M && map[rx][ry] != 1) {
			dfs(rx, ry, d);
		}
	}
}