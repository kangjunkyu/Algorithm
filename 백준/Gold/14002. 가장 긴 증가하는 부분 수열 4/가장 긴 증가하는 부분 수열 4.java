
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(max).append("\n");
		
		Stack<Integer> stk = new Stack<>();
		
		for (int i = N-1; i >=0; i--) {
			if(dp[i] == max) {
				stk.push(arr[i]);
				max--;
			}
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop() + " ");
		}
		System.out.println(sb.toString());
	}
}
