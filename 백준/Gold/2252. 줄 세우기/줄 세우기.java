import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



	static int N, M;
	static int[] indegree;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N+1];
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			indegree[b]++;

		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(indegree[i] ==0) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			System.out.print(que.peek() + " ");
			int now = que.poll();
			
			for (int i = 0; i <graph[now].size(); i++) {
				int next = graph[now].get(i);
				indegree[next]--;
				if(indegree[next]==0) {
					que.add(next);
				}
			}
		}
	}
}