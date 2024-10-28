import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		public Pos(int position, int time) {
			super();
			this.position = position;
			this.time = time;
		}

		int position;
		int time;
	}

	static int[] map;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new int[100001];

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map[N] = 1;

		bfs();

		System.out.println(map[K] - 1);

	}

	private static void bfs() {
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(N, 1));
		while (!que.isEmpty()) {
			Pos now = que.poll();
			if (check(now.position + 1)) {
				if (map[now.position + 1] == 0 || map[now.position + 1] > now.time) {
					map[now.position + 1] = now.time + 1;
					que.add(new Pos(now.position + 1, now.time + 1));
				}
			}
			if (check(now.position - 1)) {
				if (map[now.position - 1] == 0 || map[now.position - 1] > now.time) {
					map[now.position - 1] = now.time + 1;
					que.add(new Pos(now.position - 1, now.time + 1));
				}
			}
            // *2일 때는 0초가 소모, 순간이동
			if (check(now.position * 2)) {
				if (map[now.position * 2] == 0 || map[now.position * 2] > now.time) {
					map[now.position * 2] = now.time;
					que.add(new Pos(now.position * 2, now.time));
				}
			}
		}

	}

	private static boolean check(int position) {
		return position >= 0 && position <= 100000;
	}

}