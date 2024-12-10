import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int[][] dp = new int[10001][4];

			dp[1][1] = 1; // 1을 만드는 방법
			dp[2][1] = 1; // 2를 만드는 방법 1
			dp[2][2] = 1; // 2를 만드는 방법 2
			dp[3][1] = 1; // 3을 만드는 방법 1
			dp[3][2] = 1; // 3을 만드는 방법 2
			dp[3][3] = 1; // 3을 만드는 방법 3

			// 조건은 중복 허용 x
			for (int i = 4; i <= 10000; i++) {
				dp[i][1] = dp[i - 1][1]; // 모든 조합에 1을 추가한 경우
				dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // 마지막 숫자가 1, 2인 모든 조합에 2를 추가한 경우
				dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]; // 마지막 숫자가 1, 2, 3인 모든 조합에 3을 추가한 경우
			}
			//어렵네 이거..
			
			int ans = Integer.parseInt(br.readLine());
			
			int result = dp[ans][1] + dp[ans][2] + dp[ans][3];
			
			System.out.println(result);
		}
	}
}