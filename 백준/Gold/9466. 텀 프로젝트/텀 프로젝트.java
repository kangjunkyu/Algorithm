import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//data {
//	2
//	7
//	3 1 3 7 3 4 6
//	8
//	1 2 3 4 5 6 7 8
//}
public class Main {
	static int N, count;
	static int[] arr;
	static boolean[] visit, cycle;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			arr = new int[N + 1];
			visit = new boolean[N + 1];
			cycle = new boolean[N + 1];
			count = 0;
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				if(!cycle[i])
				dfs(i);
			}
			
			System.out.println(N - count);
		}
	}

	private static void dfs(int now) {
		if (visit[now]) {
			cycle[now] = true;
			count++;
		} else {
			visit[now] = true;
		}
		if(!cycle[arr[now]]) {
			dfs(arr[now]);
		}
		visit[now] = false;
		cycle[now] = true;
	}
}