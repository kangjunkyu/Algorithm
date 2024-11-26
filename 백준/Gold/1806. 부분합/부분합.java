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

		int[] num = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;

		int ans = Integer.MAX_VALUE;

		// 슬라이딩 윈도우 방법
		// 기본적으로 start와 end는 결코 N을 넘어선 안됨, 배열의 부분합이니까
		while (start <= N && end <= N) {
			// 부분합이 S보다 작다면 end를 늘린다.
			if (sum < S) {
				sum += num[end++];
			} else {
				// 아니라면 start를 늘린다. 
				ans = Math.min(ans, end - start);
				sum -= num[start++];
			}
		}

		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}