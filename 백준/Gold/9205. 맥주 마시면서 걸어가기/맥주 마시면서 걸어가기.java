import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
	static class Point{
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		int x;
		int y;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		ArrayList<Point> a; // 집, 편의점, 페스티벌에 위치를 저장하는 배열
		ArrayList<ArrayList<Integer>> graph;

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			a = new ArrayList<>();

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				a.add(new Point(x, y));
			}

			graph = new ArrayList<>();
			for (int i = 0; i < N + 2; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (Manhattan(a.get(i), a.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}

			if(BFS(graph, N)) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}

		br.close();
	}

	public static int Manhattan(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);

		boolean[] visited = new boolean[N + 2];
		visited[0] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == N + 1) {
				return true;
			}

			for (int next : graph.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}

		return false;
	}
}