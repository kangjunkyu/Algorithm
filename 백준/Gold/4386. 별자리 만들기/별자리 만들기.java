import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Star {
		int num;
		double x;
		double y;

		public Star(int num, double x, double y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int ed;
		double w;

		public Edge(int ed, double w) {
			super();
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.w < o.w)
				return -1;
			return 1;
		}
	}

	static ArrayList<Edge>[] edgeList;
	static ArrayList<Star> starList;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		edgeList = new ArrayList[N];
		starList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			starList.add(new Star(i, x, y));
			edgeList[i] = new ArrayList<>();
		}
		
		check = new boolean[starList.size()];

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double dist = Math.sqrt(Math.pow(starList.get(i).x - starList.get(j).x, 2)
						+ Math.pow(starList.get(i).y - starList.get(j).y, 2));

				edgeList[i].add(new Edge(j, dist));
				edgeList[j].add(new Edge(i, dist));
			}
		}
		
		double MST = prim();
//		System.out.printf("%.2f", MST);
		System.out.println(MST);
		
	}
	
	static double prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		double dist = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(!check[now.ed]) {
				dist += now.w;
				check[now.ed] = true;
			}
			else {
				continue;
			}
			
			for(Edge next : edgeList[now.ed]) {
				if(!check[next.ed]) {
					pq.add(new Edge(next.ed, next.w));
				}
			}
		}
		return dist;
	}
}