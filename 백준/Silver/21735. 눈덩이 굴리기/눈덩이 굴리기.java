
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;

		dfs(0, 1, 0);

		System.out.println(ans);
	}

	private static void dfs(int index, int size, int time) {
		if (time == M) {
            ans = Math.max(ans, size);
            return;
        }
        if (index >= N) {
            ans = Math.max(ans, size);
            return;
        }

        // 1칸 굴리기
        if (index + 1 <= N) {
            dfs(index + 1, size + arr[index + 1], time + 1);
        }
        // 2칸 던지기
        if (index + 2 <= N) {
            dfs(index + 2, size / 2 + arr[index + 2], time + 1);
        }
	}
}
