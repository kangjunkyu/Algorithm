import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static List<Node> list = new ArrayList<>();
	public static PriorityQueue<Integer> que = new PriorityQueue<>();
	
	
	public static class Node implements Comparable<Node> {
		int num;
		int startTime;
		int endTime;

		Node(int num, int startTime, int endTime) {
			this.num = num;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.startTime - o.startTime;
		}
	}



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int startT = Integer.parseInt(st.nextToken());
			int endT = Integer.parseInt(st.nextToken());
			

			list.add(new Node(num, startT, endT));
		}

		Collections.sort(list);

		int max = -1;

		for (int i = 0; i < n; i++) {
			
			que.add(list.get(i).endTime);
			
			while (!que.isEmpty() && que.peek() <= list.get(i).startTime) {
//				System.out.println(que.peek());
//				System.out.println("-------");
				que.poll();
			}
//			System.out.println(que.peek());

			max = Math.max(max, que.size());
		}

		System.out.println(max);
	}
}