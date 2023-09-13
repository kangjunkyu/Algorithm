import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		N = Integer.valueOf(inputs[0]);
		K = Integer.valueOf(inputs[1]);
		
		int result = bfs(N);
		System.out.println(result);
	}

	static int bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.add(start);

		int n = 0;
		check[start] = 1;

		while (!que.isEmpty()) {
			n = que.poll();

			if (n == K) {
				return check[n] - 1;
			}
			if (n - 1 > 0 && check[n - 1] == 0) {
				check[n - 1] = check[n] + 1;
				que.add(n - 1);
			}
			if (n + 1 <= 100000 && check[n + 1] == 0) {
				check[n + 1] = check[n] + 1;
				que.add(n + 1);
			}
			if (2 * n <= 100000 && check[n * 2] == 0) {
				check[2 * n] = check[n] + 1;
				que.add(n * 2);
			}
		}
		return N;
	}

}