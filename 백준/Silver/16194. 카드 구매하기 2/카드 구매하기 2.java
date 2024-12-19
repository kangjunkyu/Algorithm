
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		int[] p = new int[N+1];
		int[] dp = new int[10001];
		
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			//초기화 해야함 이건 5장 살 때 5장 카드의 가격을 넣는 것
			dp[i] = p[i];
			for (int j = 1; j <= i; j++) {
				// 카드의 정보는 1장씩 커진다. 1: 5, 2:10 ... 등 각 장수에 대한 금액이니까 ++1이 맞다.
				dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
