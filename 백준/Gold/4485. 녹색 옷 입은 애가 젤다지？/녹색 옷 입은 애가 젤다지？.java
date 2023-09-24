import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	public Node(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	int x;
	int y;
	int w;

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.w - o.w;
	}

}

public class Main {
	static int arr[][];
	static boolean check[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int dist[][];
	static int N;
	static int INF = 200000000;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 0;

		while (true) {
			tc++;
			N = Integer.parseInt(br.readLine());

			if(N==0) {
				break;
			}
			arr = new int[N][N];
			check = new boolean[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}

			bfs(new Node(0, 0, 0));

			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);

		}

	}

	static void bfs(Node start) {
		PriorityQueue<Node> que = new PriorityQueue<>();

		que.add(start);

		dist[start.x][start.y] = arr[start.x][start.y];

		while (!que.isEmpty()) {
			Node now = que.poll();
			check[now.x][now.y] = true;
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc]) {
					continue;
				}
				if (dist[nr][nc] > dist[now.x][now.y] + arr[nr][nc]) {
					dist[nr][nc] = dist[now.x][now.y] + arr[nr][nc];
					que.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

}