import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int min = Integer.MAX_VALUE - 1;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//동전의 정보를 배열에 담는다. dp를 정상적으로 반복문을 돌리기 위해 시작점은 1부터로 한다.
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[K + 1];
		//dp는 모두 큰 값을 담아 비교할 수 있도록 한다. 만약 비교할 수 없다면 큰 값이 들어가있겠지?
		for (int i = 1; i <= K; i++) {
			dp[i] = min;
		}
		
		//+1을 해주는 이유는 dp배열은 기본적으로 큰 값이 들어가있다. 하지만 dp0은 0일테니 모두 0으로 변환된다.
		
		for (int i = 1; i <= N; i++) {
			for (int j = arr[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		
		if(dp[K] == min) {
			System.out.println(-1);
		}else {
			System.out.println(dp[K]);
		}
		
//		System.out.println(Arrays.toString(dp));
	}
}