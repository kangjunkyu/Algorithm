import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static int N;
	static String word;
	static char[][] map;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(br.readLine());
//		N = sc.nextInt();

		map = new char[N + 1][N + 1];
		check = new boolean[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			word = br.readLine();
			for (int j = 0; j < N; j++) {
//				char ch = word.charAt(j);
				map[i][j] = word.charAt(j);
			}
		}

		// 노멀인 경우?

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		int nomal_cnt = cnt;
		cnt = 0;
		check = new boolean[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		int not_nomal_cnt = cnt;

		System.out.println(nomal_cnt + " " + not_nomal_cnt);
	}

	static void dfs(int x, int y) {
		check[x][y] = true;
		char ch = map[x][y];
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX > N || newY < 0 || newY > N) {
				continue;
			}
			if (!check[newX][newY] && map[newX][newY] == ch) {
				dfs(newX, newY);
			}
		}
	}
}