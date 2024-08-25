import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] check;

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

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j)) {
//					System.out.println("test");
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static boolean dfs(int i, int j) {
		boolean result = false;

		if (i >= N || i < 0 || j >= M || j < 0) {
			return true;
		}

		if (check[i][j]) {
			return false;
		}

		if (map[i][j] == 'T') {
			return true;
		} else if (map[i][j] == 'F') {
			return false;
		}

		check[i][j] = true;

		if (map[i][j] == 'U') {
			result = dfs(i - 1, j);
		} else if (map[i][j] == 'R') {
			result = dfs(i, j + 1);
		} else if (map[i][j] == 'D') {
			result = dfs(i + 1, j);
		} else if (map[i][j] == 'L') {
			result = dfs(i, j - 1);
		}

		map[i][j] = result ? 'T' : 'F';

		check[i][j] = false;
		return result;
	}
}