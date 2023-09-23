import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, cnt;
	static boolean[][] checked;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(map[N-1][M-1]);

		
	}
	
	static void bfs(int x, int y) {
		checked[x][y] = true;
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {x,y});
		while(!que.isEmpty()) {
			int nx = que.peek()[0];
			int ny = que.peek()[1];
			
			que.poll();
			
			for (int i = 0; i < 4; i++) {
				int newx = nx + dx[i];
				int newy = ny + dy[i];
				if(newx < 0 || newy < 0 || newx >= N || newy >=M || checked[newx][newy] || map[newx][newy] == 0) {
					continue;
				}
				que.add(new int[] {newx, newy});
				map[newx][newy] = map[nx][ny]+1;
				checked[newx][newy] = true;
			}
		}
	}
}