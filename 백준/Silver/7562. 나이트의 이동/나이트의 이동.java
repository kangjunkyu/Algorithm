import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int N;
	static int[][] board;
	static boolean[][] check;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			check = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			int stx = Integer.parseInt(st.nextToken());
			int sty = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int edx = Integer.parseInt(st.nextToken());
			int edy = Integer.parseInt(st.nextToken());

			bfs(new Node(stx, sty));
			
			System.out.println(board[edx][edy]);
		}
	}
	
	static void bfs(Node start) {
		Queue<Node> que = new LinkedList<>();
		
		que.add(start);
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(!check[now.x][now.y]) {
				
				for (int i = 0; i < 8; i++) {
					
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(nx<0 || ny < 0 || nx>=N || ny >= N || check[nx][ny]) {
						continue;
					}
					
					que.add(new Node(nx,ny));
					board[nx][ny] = board[now.x][now.y] +1;
					
					check[now.x][now.y] = true;
				}
			}
		}
	}
}