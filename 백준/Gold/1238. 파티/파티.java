import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int ed;
		int w;

		public Node(int ed, int w) {
			super();
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	static int N, M, X;
	static ArrayList<ArrayList<Node>> graph, reverse;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		//돌아오는 길도 계산해야하기 때문에 list를 두개 만들어야 한다.
		graph = new ArrayList<>();
		reverse = new ArrayList<>();
		
		//리스트에 리스트 넣어주는 건 필수.
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}
		
		//돌아가는 길에 대한 정보도 함께 입력한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, weight));
			reverse.get(end).add(new Node(start, weight));
		}

		int ans = 0;
		
		//2개가 나온다. 이건 리턴값이 배열로 받음을 알아야한다.
		
		int[] dist = dijkstra(graph);
		int[] dist2 = dijkstra(reverse);
		
		//각 비교군중 가장 오래걸리는 길에 대한 출
		for (int j = 1; j <= N; j++) {
			ans = Math.max(ans, dist[j] + dist2[j]);
		}
		
		System.out.println(ans);
	}

	static int[] dijkstra(ArrayList<ArrayList<Node>> find) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//Q에 X좌표와 가중치를 큐에 넣어준다.
		pq.add(new Node(X, 0));
		
		//배열을 생성하
		boolean[] check = new boolean[N + 1];
		//방문 가중치에 대해 입력할 배열을 만들어준다.
		int[] dist = new int[N + 1];
		//배열을 INF로 채워준다.
		Arrays.fill(dist, INF);
		//시작점에 가중치를 0으로 선언한다.
		dist[X] = 0;
		
		//큐가 비일 때 까지 빼낸다.
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			//만약 방문하지 않았다면, 방문 체크를 해준다.
			if (!check[now.ed]) {
				check[now.ed] = true;
				
				// 다음 좌표를 넣을 수 있게끔 반복식을 새운다.
				for (Node next : find.get(now.ed)) {
					//만약 다음 방문장소에 방문한 적이 없고.
					// 다음 지점의 가중치가 현재 위치에서 다음 가중치에 더한 것보다 크다면,
					// 당연히 바꿔준다.
					// 바꿔준 값을 pq에 add해준다.
					if (!check[next.ed] && dist[next.ed] > dist[now.ed] + next.w) {
						dist[next.ed] = dist[now.ed] + next.w;
						pq.add(new Node(next.ed, dist[next.ed]));
					}

				}
			}
		}
		//리턴으로 배열을 넣어준다
		return dist;

	}

}