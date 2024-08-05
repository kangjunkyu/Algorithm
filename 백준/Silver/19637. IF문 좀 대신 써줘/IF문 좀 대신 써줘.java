import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Info {

		public Info(String status, int power) {
			super();
			this.status = status;
			this.power = power;
		}

		String status;
		int power;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<Info> set = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			set.add(new Info(st.nextToken(), Integer.parseInt(st.nextToken())));
		}

		for (int i = 0; i < M; i++) {
			int model = Integer.parseInt(br.readLine());

			int start = 0;
			int end = N - 1;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (set.get(mid).power < model) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			sb.append(set.get(start).status).append("\n");
		}
		System.out.println(sb);
	}
}