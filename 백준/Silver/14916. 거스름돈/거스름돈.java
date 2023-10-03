import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[100001];

		dp[0] = 0;
		dp[2] = 1;
		dp[1] = 0;
		dp[3] = 0;
		dp[4] = 2;
		dp[5] = 1;

//		for (int i = 4; i <= N; i++) {
//			int min = 987654321;
//
//			if (i >= 5) {
//				min = Math.min(dp[i - 2] + 1, min);
//			}
//			if (i >= 2) {
//				min = Math.min(dp[i - 5] + 1, min);
//			}
//
//			dp[i] = min;
//		}

		for (int i = 6; i <= N; i++) {
			if (dp[i - 2] == 0 && dp[i - 5] == 0) {
				dp[i] = 0;
			} else if (dp[i - 2] > 0 && dp[i - 5] == 0) {
				dp[i] = dp[i - 2] + 1;
			} else if (dp[i - 2] == 0 && dp[i - 5] > 0) {
				dp[i] = dp[i - 5] + 1;
			} else {
				dp[i] = Math.min(dp[i - 2], dp[i - 5])+1;
			}
		}

		if (dp[N] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}