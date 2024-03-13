import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] check;
	static int answer;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int FX, FY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

//		print();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				FX = i;
				FY = j;
				if (dfs(i, j, 1) == 1) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");

	}

	private static int dfs(int x, int y, int count) {
		check[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
//			if (!check[nx][ny]) {
//				check[nx][ny] = true;
//				dfs(nx, ny, count + 1);
//				check[nx][ny] = false;
//			}
			if (map[nx][ny] == map[x][y]) {
				if (check[nx][ny]) {
					if (count >= 4 && nx == FX && ny == FY) {
						return 1;
					}
				} else {
					if (dfs(nx, ny, count + 1) == 1) {
						return 1;
					}
				}
			}
		}
		check[x][y] = false;
		return 0;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}