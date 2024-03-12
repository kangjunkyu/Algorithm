import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] arr;
	static int[] arr2;
	static boolean[] check;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		arr2 = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		System.out.println(max);

	}

	private static void dfs(int count) {
		if (count == N) {
			max = Math.max(print(), max);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr2[count] = arr[i];
				dfs(count + 1);
				check[i] = false;
			}
		}
	}

	private static int print() {
		ans = 0;
		for (int i = 0; i < N - 1; i++) {
			ans += Math.abs(arr2[i] - arr2[i + 1]);
		}
		return ans;
	}
}