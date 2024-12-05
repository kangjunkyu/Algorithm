import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int d;
		int w;

		public Node(int d, int w) {
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	static int N, M;
	static int[] dist;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		dist[S] = 0;

		solve(S);

		System.out.println(dist[T]);

	}

	private static void solve(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (dist[now.d] < now.w)
				continue;

			for (Node next : list[now.d]) {
				int nextW = now.w + next.w;
				if (nextW < dist[next.d]) {
					dist[next.d] = nextW;
					pq.add(new Node(next.d, nextW));
				}
			}
		}

	}
}