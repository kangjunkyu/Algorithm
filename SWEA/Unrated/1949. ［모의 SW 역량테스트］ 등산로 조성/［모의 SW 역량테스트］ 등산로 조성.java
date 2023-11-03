
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K, result;
	static int[][] mountine;
	static boolean[][] checked;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mountine = new int[N][N];
			checked = new boolean[N][N];
			result = Integer.MIN_VALUE + 1;

			int Top = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mountine[i][j] = Integer.parseInt(st.nextToken());
					Top = Math.max(mountine[i][j], Top);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Top != mountine[i][j])
						continue;

					checked[i][j] = true;
					DFS(i, j, 1, mountine[i][j], K);
					checked[i][j] = false;
				}
			}

			System.out.println("#" + t + " " + result);
			;
		}

	}

	private static void DFS(int x, int y, int length, int height, int k) {
		result = Math.max(length, result);

		for (int i = 0; i < 4; i++) {
			int nx = dirX[i] + x;
			int ny = dirY[i] + y;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || checked[nx][ny])
				continue;

			if (k == 0) {
				if (mountine[nx][ny] < height) {
					checked[nx][ny] = true;
					DFS(nx, ny, length + 1, mountine[nx][ny], k);
					checked[nx][ny] = false;
				}
			} else {
				if (mountine[nx][ny] < height) {
					checked[nx][ny] = true;
					DFS(nx, ny, length + 1, mountine[nx][ny], k);
					checked[nx][ny] = false;
				} else if ((mountine[nx][ny] - k) < height) {
					checked[nx][ny] = true;
					DFS(nx, ny, length + 1, height - 1, 0);
					checked[nx][ny] = false;
				}
			}
		}
	}
}
