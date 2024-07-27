import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = '.';
			}
		}

		String str = br.readLine();

		int x = 0, y = 0;

		for (int i = 0; i < str.length(); i++) {
			char commend = str.charAt(i);

			int nx = x;
			int ny = y;

			if (commend == 'D') {
				nx += 1;
			} else if (commend == 'U') {
				nx -= 1;
			} else if (commend == 'R') {
				ny += 1;
			} else {
				ny -= 1;
			}

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}

			if (map[x][y] == '-' && (commend == 'D' || commend == 'U')) {
				map[x][y] = '+';
			} else if (map[x][y] == '|' && (commend == 'R' || commend == 'L')) {
				map[x][y] = '+';
			} else if (map[x][y] == '.' && (commend == 'D' || commend == 'U')) {
				map[x][y] = '|';
			} else if (map[x][y] == '.' && (commend == 'R' || commend == 'L')) {
				map[x][y] = '-';
			}

			if (map[nx][ny] == '-' && (commend == 'D' || commend == 'U')) {
				map[nx][ny] = '+';
			} else if (map[nx][ny] == '|' && (commend == 'R' || commend == 'L')) {
				map[nx][ny] = '+';
			} else if (map[nx][ny] == '.' && (commend == 'D' || commend == 'U')) {
				map[nx][ny] = '|';
			} else if (map[nx][ny] == '.' && (commend == 'R' || commend == 'L')) {
				map[nx][ny] = '-';
			}

			x = nx;
			y = ny;

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}

//++.|.
//.+-+.