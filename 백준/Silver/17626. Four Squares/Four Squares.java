import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N+1];

		//1은 1의 제곱으로 반환하면 되니
		dp[1] = 1;
		int min = 0;
		
		//그러니 우리는 2부터 돈다.
		for (int i = 2; i <= N; i++) {
			min = Integer.MAX_VALUE;
			//배열 안에 채워질 내용이다. 잘보면 j는 1부터 돌린다. 그 값이 j*j가 N까지 증가해야 하는 것
			for (int j = 1; j * j <= i; j++) {
				//여기서 i를 빼는 이유는 
				int temp = i-j * j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[N]);
	}
}