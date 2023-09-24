import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, start, cnt, max;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph;
	static final int INF = 200000000;

	static class Node {
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		int v; // 다음 노드
		int w; // 가중치

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			visited = new boolean[N + 1];
			dist = new int[N + 1];
			cnt = 0;
			max = 0;

			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
				dist[i] = INF;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				graph.get(v).add(new Node(u, w));
			}

			bfs(new Node(start, 0));

			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});

		queue.add(start);
		dist[start.v] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (!visited[now.v]) {
				visited[now.v] = true;
				cnt++;

				for (Node next : graph.get(now.v)) {
					if (dist[next.v] > dist[now.v] + next.w) {
						dist[next.v] = dist[now.v] + next.w;
						queue.add(new Node(next.v, dist[next.v]));
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (dist[i] != INF && dist[i] > max) {
				max = dist[i];
			}
		}
	}
}