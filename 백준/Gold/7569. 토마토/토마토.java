import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int M, N, H, max;
	static int[][][] box;
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		//3차원에서 높이는 처음 들어간다.
		box = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {

				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					// 1을 찾아서 스택에 넣어야 한다. 그래야 비교를 하며 탐색을 돌릴 수 있으니
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						que.add(new int[] { i, j, k });
					}
				}
			}
		}
		// 반환값을 int로 받는게 정석인듯, 가장 큰 자리에서 자리에서 출력할거니까
		System.out.println(bfs());

	}

	private static int bfs() {
		while (!que.isEmpty()) {

			int z = que.peek()[0];
			int x = que.peek()[1];
			int y = que.peek()[2];

			que.poll();

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				// 컨티뉴를 시켜라.. 좀..
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
					continue;
				} else {
					// 익은 토마토 사방에 안익은 토마토가 있다고?! 그럼 바꿔야지
					if (box[nz][nx][ny] == 0) {
						que.add(new int[] { nz, nx, ny });
						box[nz][nx][ny] = box[z][x][y] + 1;
					}
				}
			}

		}
		max = Integer.MIN_VALUE;

		// 만약에 전부 돌렸을 때 다 0이면 -1를 출력해야한다.

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						return -1;
					}
					if (max < box[i][j][k])
						max = box[i][j][k];
				}
			}
		}
		// 다 익었어..? 그럼 0 출력해 뭣하러 해 빨리 팔아야
		if (max == 1) {
			return 0;
		} else {

			return max - 1;
		}
	}
}