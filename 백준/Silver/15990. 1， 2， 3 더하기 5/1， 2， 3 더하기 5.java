
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		long [][] dp = new long[100001][4];

		dp[1][1] = 1; // 1은 1만 됨
		dp[2][2] = 1; // 2도 2만 됨 11은 연속된 같은 수
		dp[3][1] = 1; // 3은 1+2
		dp[3][2] = 1; // 2+1
		dp[3][3] = 1; // 3 총 3개지가 가능함

		for (int i = 4; i < 100001; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
		}

		for (int i = 0; i < TC; i++) {
			int t = Integer.parseInt(br.readLine());
			System.out.println((dp[t][1] + dp[t][2] + dp[t][3]) % 1_000_000_009);
		}
	}
}

//3
//4
//7
//10