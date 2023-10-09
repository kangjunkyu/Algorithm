import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, Phase, cnt;
	static int belt[];
	static boolean robot[];
//	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[N * 2];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		Phase = 0;

		while (true) {
			Phase++;
			int temp = belt[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;

			for (int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;

			robot[N - 1] = false;

			for (int i = N - 1; i > 0; i--) {
				if (robot[i - 1] && !robot[i] && belt[i] > 0) {
					robot[i] = true;
					robot[i - 1] = false;
					belt[i]--;
					robot[N - 1] = false;
				}
			}

			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
//			check = true;
			
			cnt = 0;
			for (int i = 0; i < N * 2; i++) {
				if (belt[i] == 0) {
					cnt++;
				}
			}
			if (cnt >= K) {
				break;
			}
		}
		System.out.println(Phase);;
	}
}