import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(br.readLine());

			int arr[] = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int K = Integer.parseInt(br.readLine());

			int[] dp = new int[K + 1];

			int cnt = 0;

			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = arr[i]; j <= K; j++) {
					dp[j] += dp[j - arr[i]];
				}
			}
			System.out.println(dp[K]);
		}
	}
}