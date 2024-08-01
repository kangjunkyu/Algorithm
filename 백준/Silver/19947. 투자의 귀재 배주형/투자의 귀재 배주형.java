import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int ansA = 0;
		int ansB = 0;
		int ansC = 0;
		long[] dp = new long[Y + 1];

		dp[0] = H;

		for (int i = 1; i <= Y; i++) {
//			if (i % 3 == 0) {
//				ansB += (int) (H * 0.2);
//				System.out.println("ansB" + ansB);
//			} else if (i % 5 == 0) {
//				ansC += (int) (H * 0.35);
//				System.out.println("ansC" + ansC);
//			}
//			ansA += (int) (H * 0.05);
//			System.out.println("ansA" + ansA);

			dp[i] = (long) (dp[i - 1] * 1.05);

			if (i >= 3) {
				dp[i] = (long) Math.max(dp[i - 3] * 1.2, dp[i]);
			}
			if (i >= 5) {
				dp[i] = (long) Math.max(dp[i - 5] * 1.35, dp[i]);
			}
		}

//		int ans = Math.max(ansA, Math.max(ansB, ansC)) + H;

		System.out.println(dp[Y]);
	}
}