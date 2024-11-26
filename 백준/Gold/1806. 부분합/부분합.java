import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N+1];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		int ans = Integer.MAX_VALUE;
		while(start <= N && end <= N) {
			if(sum < S) {
				sum += num[end++];
			}else {
				ans = Math.min(ans, end-start);
				sum -= num[start++];
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}