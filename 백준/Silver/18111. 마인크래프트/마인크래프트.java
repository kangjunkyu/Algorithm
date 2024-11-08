import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int[][] map;
	static int higher, minSec, min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		max = 0;
		min = 1234567890;
		higher = 0;
		minSec = 1234567890;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		solve();
		
		System.out.println(minSec + " " + higher);

	}

	private static void solve() {
		for (int pos = min; pos <= max; pos++) {
			int sec = 0;
			int block = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (pos > map[i][j]) {
						sec += pos - map[i][j];
						block -= pos - map[i][j];
					} else if (pos < map[i][j]) {
						sec += (map[i][j] - pos) * 2;
						block += map[i][j] - pos;
					}
				}
			}
			if (block < 0) {
				continue;
			}
			if (minSec >= sec) {
				minSec = sec;
				higher = Math.max(higher, pos);
			}
		}
	}
}