import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, cost;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		check = new boolean[N];
		cost = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			check[i] = true;
			dfs(i, i, 0, 0);
		}

		System.out.println(cost);
	}

	private static void dfs(int start, int now, int depth, int sum) {
		if (depth == N - 1) {
			if (map[now][start] != 0) {
				sum += map[now][start];
				cost = Math.min(cost, sum);
			}
		}

		for (int i = 0; i < N; i++) {
			if (!check[i] && map[now][i] > 0) {
				check[i] = true;
				dfs(start, i, depth + 1, sum + map[now][i]);
				check[i] = false;
			}
		}
	}
}