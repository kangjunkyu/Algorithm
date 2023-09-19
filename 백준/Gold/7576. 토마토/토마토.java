import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M, N, max;
	static int[][] box;
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				//1을 찾아서 스택에 넣어야 한다. 그래야 비교를 하며 탐색을 돌릴 수 있으니
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					que.add(new int[] { i, j });
				}
			}
		}
		//반환값을 int로 받는게 정석인듯, 가장 큰 자리에서 자리에서 출력할거니까 
		System.out.println(bfs());

	}

	private static int bfs() {
		while (!que.isEmpty()) {

			int x = que.peek()[0];
			int y = que.peek()[1];

			que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//컨티뉴를 시켜라.. 좀..
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;}
				else {
					// 익은 토마토 사방에 안익은 토마토가 있다고?! 그럼 바꿔야지
					if (box[nx][ny] == 0) {
						que.add(new int[] { nx, ny });
						box[nx][ny] = box[x][y] + 1;
					}
				}
			}

		}
		max = Integer.MIN_VALUE;
		
		//만약에 전부 돌렸을 때 다 0이면 -1를 출력해야한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
				if (max < box[i][j])
					max = box[i][j];
			}
		}
		//다 익었어..? 그럼 0 출력해 뭣하러 해 빨리 팔아야
		if (max == 1) {
			return 0;
		} else {

			return max - 1;
		}
	}
}