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
		int H = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		boolean[] check = new boolean[N];

		int totalSum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			totalSum += arr[i];
			cnt++;

			if (totalSum >= H) {
				System.out.println(cnt);
				return;
			}
		}

		if (totalSum < H) {
			System.out.println("-1");
		}

	}

}