import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] arr = new char[N];

		String PH = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = PH.charAt(i);
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] == 'P') {
				int Lidx = i - K;
				int Ridx = i + K;

				if (Lidx < 0)
					Lidx = 0;
				if (Ridx >= N)
					Ridx = N - 1;

				boolean check = false;

				for (int j = Lidx; j < i; j++) {
					if (arr[j] == 'H') {
						arr[j] = 'N';
						check = true;
						ans++;
						break;
					}
				}
				if (!check) {
					for (int j = i + 1; j <= Ridx; j++) {
						if (arr[j] == 'H') {
							arr[j] = 'N';
							check = true;
							ans++;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(ans);

	}
}