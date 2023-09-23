import java.util.Scanner;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M, x, y, cnt;

	static boolean[][] check;
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new char[N][M];
		check = new boolean[N][M];

		x = 0;
		y = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);

				if (arr[i][j] == 'I') {
					x = i;
					y = j;
				}

			}
		}
		dfs(x, y);

		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	public static void dfs(int x, int y) {
		check[x][y] = true;

		if (arr[x][y] == 'P') {
			cnt++;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny] == true) {
				continue;
			} else {
				if (arr[nx][ny] != 'X') {
					dfs(nx, ny);
				}
			}
		}
	}
}