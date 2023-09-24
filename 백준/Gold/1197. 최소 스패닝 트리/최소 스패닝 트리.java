import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class node implements Comparable<node>{
		int to;
		int w;
		public node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static int V, E;
	static ArrayList<node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			list[A].add(new node(B,W));
			list[B].add(new node(A,W));
		}
		System.out.println(prim());
	}
	public static long prim() {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		pq.add(new node(1,0));
		
		long res = 0;
		long cnt = 0;
		
		while(!pq.isEmpty()){
			node nd = pq.poll();
			
			if(visited[nd.to])
				continue;
			
			res += nd.w;
			visited[nd.to] = true;
			
			if(++cnt == V)
				return res;
			
			for (int i = 0; i < list[nd.to].size(); i++) {
				node next = list[nd.to].get(i);
				if(visited[next.to])
					continue;
				pq.add(next);
			}
		}
		return res;
	}
}