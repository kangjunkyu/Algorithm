
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 2];
		int[][] dayNpay = new int[2][N + 2];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			dayNpay[0][i] = Integer.parseInt(st.nextToken());
			dayNpay[1][i] = Integer.parseInt(st.nextToken());
		}

        for (int i = N; i >= 1; i--) {
            if (i + dayNpay[0][i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dayNpay[1][i] + dp[i + dayNpay[0][i]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[1]);
	}
}
