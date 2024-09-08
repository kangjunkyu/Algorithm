import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M, max;
	static int[] arr;
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			//right 찾으려면 해야함
			max = Math.max(arr[i], max);
		}

		//큰수부터 꺼내서 최적의 경우를 찾기 위함.
		Arrays.sort(arr);

		solve();

		System.out.println(result);
	}

	private static void solve() {
		// TODO Auto-generated method stub
		long left = 0;
		// right는 최대한 오래 걸리는 시간이다.
		// 보면 max(최대시간)을 M(친구수)으로 곱했으니 최대치가 된다.
		long right = max * M;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < arr.length; i++) {
				long count = mid / arr[i];

				// 이건 당연하지,, 모든 배열을 다 돌되 sum이 M을 넘으면 불가하다는거니까
				if (sum >= M) {
					break;
				}
				// 아니면 더해 sum에
				sum += count;
			}
			// 다 돌았는데 된다? 그럼 비교해야지 가장 작은 걸, 그걸 while문에서 반복으로 돌린다.
			if (sum >= M) {
				right = mid - 1;
				result = Math.min(mid, result);
			} else {
				left = mid + 1;
			}

		}
	}
}