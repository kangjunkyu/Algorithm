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
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}

	static int N, M, sum,max;
	static boolean check[];
	static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		max = 0;

		graph = new ArrayList<>();

		check = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		prim(new Node(1, 0));
		System.out.println(sum-max);
	}

	static void prim(Node start) {
		PriorityQueue<Node> que = new PriorityQueue<>();

		que.add(start);

		while (!que.isEmpty()) {
			Node now = que.poll();
			if (!check[now.ed]) {
				check[now.ed] = true;
				sum += now.w;
				max = Math.max(max, now.w);

				for (Node next : graph.get(now.ed)) {
//				if (!check[next.ed]) {
					que.add(next);
//				}
				}
			}
		}
	}
}