import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	static int N;
	static int[][] map;
	static int[][] check;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				check[i][j] = 10000;
			}
		}

		br.close();
		bfs();

		System.out.println(check[N - 1][N - 1]);

	}

	private static void bfs() {
	    Queue<Node> que = new LinkedList<>();

	    que.add(new Node(0, 0));
	    check[0][0] = 0;

	    while (!que.isEmpty()) {
	        Node now = que.poll();

	        for (int i = 0; i < 4; i++) {
	            int nx = now.x + dx[i];
	            int ny = now.y + dy[i];

	            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
	                int newCost = check[now.x][now.y] + (map[nx][ny] == 0 ? 1 : 0);
	                if (newCost < check[nx][ny]) {
	                    check[nx][ny] = newCost;
	                    que.add(new Node(nx, ny));
	                }
	            }
	        }
	    }
	}
}