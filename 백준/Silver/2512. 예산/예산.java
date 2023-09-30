import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int left = 0;
		int right = -100;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		long total = Integer.parseInt(br.readLine());

		while (left <= right) {
			int mid = (left + right) / 2;
			int burget = 0;

			for (int i = 0; i < N; i++) {
				if (mid < arr[i]) {
					burget += mid;
				} else {
					burget += arr[i];
				}
			}
			
			if (burget <= total) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
}