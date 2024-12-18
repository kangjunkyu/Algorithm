import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		long[] x = new long[N + 1];
		long[] y = new long[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());

		}
		// 첫 N에 대해서는 첫 값에 대한 value가 들어가 있어야 마지막 계산이 정확히 된다.
		// i+1은 N까지 가니까

		x[N] = x[0];
		y[N] = y[0];
		
		// 신발끈규칙
		// 왼쪽 아래로 이어지는 배열의 값을 서로 곱한다.
		// 오른쪽 아래로 이어지는 배열의 값을 서로 곱한다.

		long sumx = 0;
		long sumy = 0;

		for (int i = 0; i < N; i++) {
			sumx += x[i] * y[i + 1];
			sumy += x[i + 1] * y[i];
		}
		//합산 값의 절대값을 2로 나누어준다.
		String area = String.format("%.1f", Math.abs(sumx - sumy) / 2.0);
		
		System.out.println(area);
	}
}
