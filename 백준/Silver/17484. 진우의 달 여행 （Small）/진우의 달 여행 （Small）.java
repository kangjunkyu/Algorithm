import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int result;
	static int[] dx = { 1, 1, 1 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				solve(0, map[0][i], i, j);
			}
		}

		System.out.println(result);

	}

	private static void solve(int nowX, int sum, int nowY, int d) {

		if (nowX == N - 1) {
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (d == i) {
				continue;
			}
			int nx = nowX + dx[i];
			int ny = nowY + dy[i];

			if (nx >= N || ny < 0 || ny >= M || ny < 0) {
				continue;
			}
//				System.out.println("sum check : " + sum + map[nx][ny]);
				solve(nx, sum + map[nx][ny], ny, i);
			
		}

	}
}