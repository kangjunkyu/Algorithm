import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		public Node(int ed, int w) {
			super();
			this.ed = ed;
			this.w = w;
		}

		int ed;
		int w;

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static int N, M, start, end;
	static ArrayList<ArrayList<Node>> graph;
	static boolean check[];
	static int dist[];
	static int INF = 200000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		check = new boolean[N + 1];
		dist = new int[N + 1];

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		bfs(new Node(start, 0));

		System.out.println(dist[end]);
	}

	public static void bfs(Node start) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		dist[start.ed] = 0;
		que.add(start);

		while (!que.isEmpty()) {
			Node now = que.poll();
			if (!check[now.ed]) {
				check[now.ed] = true;
				
				for(Node next : graph.get(now.ed)) {
					if(dist[next.ed] > dist[now.ed] + next.w) {
						dist[next.ed] = dist[now.ed] + next.w;
						
						que.add(new Node(next.ed, dist[next.ed]));
					}
				}
			}
		}
	}
}