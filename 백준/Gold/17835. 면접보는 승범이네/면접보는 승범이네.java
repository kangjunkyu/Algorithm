import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		ArrayList<Node>[] city = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			city[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			city[V].add(new Node(U, C));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int examPlace = Integer.parseInt(st.nextToken());
			pq.add(new Node(examPlace, 0));
			dist[examPlace] = 0;
		}
		

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowCity = now.city;
			long nowDist = now.dist;
			if (nowDist > dist[nowCity]) {
				continue;
			}
			for(Node next : city[nowCity]) {
				if(nowDist + next.dist < dist[next.city]) {
					dist[next.city] = nowDist + next.dist;
					pq.add(new Node(next.city, nowDist + next.dist));
				}
			}
		}
		long ans = 0;
		int ansIndex = 0;
		for (int i = 1; i <= N; i++) {
			if(ans < dist[i]) {
				ans = dist[i];
				ansIndex = i;
			}
		}
		
		System.out.println(ansIndex);
		System.out.println(ans);
	}

	static class Node implements Comparable<Node> {
		public Node(int city, long dist) {
			super();
			this.city = city;
			this.dist = dist;
		}

		int city;
		long dist;

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);
		}

	}
}