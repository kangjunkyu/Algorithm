
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[N + 1];
		int[] dp = new int[K+1];
		//암 것도 고르지 않아도 1이 될 수 있다
		dp[0] =1;
		
		//합이 필요하다 그렇기에 += dp[j-arr[i]]를 dp[j] 더해야한다.
		//arr[i] 가 5면 j도 5고 1씩 증가할테니 5, 6, 7, 8, 9, 10이 되고
		// dp[5-5] dp[6-5] dp[7-5], dp[8-5]... 가 된다
		// 왜냐? dp[?]보다 1이라도 크면 적용이 가능하니까 계속 더할 수가 있다.
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for (int j = arr[i]; j <= K; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}

		System.out.println(dp[K]);
	}
}
