import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] checked;
	static ArrayList<Node> list[];

	static class Node {
		int d;
		int w;

		public Node(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(find(start,end));
		}
	}

	static int find(int start, int end) {
		checked = new boolean[N+1];
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(start,0));
		checked[start] = true;
		
		int dist = 0;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(now.d == end) {
				dist = now.w;
				break;
			}
			
			for(Node temp : list[now.d]) {
				if(!checked[temp.d]) {
					que.add(new Node(temp.d, now.w + temp.w));
					checked[temp.d] = true;
				}
			}
		}
		return dist;
	}
}