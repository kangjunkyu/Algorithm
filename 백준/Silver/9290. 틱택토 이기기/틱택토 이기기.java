import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new char[3][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				String str = br.readLine();
				for (int k = 0; k < 3; k++) {
					map[j][k] = str.charAt(k);
				}
			}

			char mal = br.readLine().charAt(0);

			tictactoc(mal);

			System.out.println("Case " + (i + 1) + ":");
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}
		}
	}

	private static void tictactoc(char mal) {
		for (int i = 0; i < 3; i++) {
			cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (map[j][i] == mal) {
					cnt++;
				}
			}

			if (cnt >= 2) {
				map[0][i] = mal;
				map[1][i] = mal;
				map[2][i] = mal;
				return;
			}
		}

		for (int i = 0; i < 3; i++) {
			cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == mal) {
					cnt++;
				}
			}

			if (cnt >= 2) {
				map[i][0] = mal;
				map[i][1] = mal;
				map[i][2] = mal;
				return;
			}
		}

		cnt = 0;
		for (int i = 0; i < 3; i++) {
			int j = i;
			if (map[i][j] == mal) {
				cnt++;
			}

			if (cnt >= 2) {
				map[0][0] = mal;
				map[1][1] = mal;
				map[2][2] = mal;
				return;
			}
		}

		cnt = 0;
		int j = 2;
		for (int i = 0; i < 3; i++) {
			if (map[i][j] == mal) {
				cnt++;
			}

			if (cnt >= 2) {
				map[0][2] = mal;
				map[1][1] = mal;
				map[2][0] = mal;
				return;
			}
			j -= 1;
		}
	}
}