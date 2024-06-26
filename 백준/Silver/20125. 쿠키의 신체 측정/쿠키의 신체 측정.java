import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		char[][] cookie = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				cookie[i][j] = str.charAt(j);
			}
		}

		int xPoint = 0;

		int yPoint = 0;

		int size[] = new int[5];

		for (int i = 0; i < N; i++) {
			boolean check = false;
			for (int j = 0; j < N; j++) {
				if (cookie[i][j] == '*') {
					yPoint = i + 2;
					xPoint = j + 1;
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
		}

		for (int i = 0; i < xPoint - 1; i++) {
			if (cookie[yPoint - 1][i] == '*') {
				size[0]++;
			}
		}

		for (int i = xPoint; i < N; i++) {
			if (cookie[yPoint - 1][i] == '*') {
				size[1]++;
			}
		}

		for (int i = yPoint; i < N; i++) {
			if (cookie[i][xPoint - 1] == '*') {
				size[2]++;
			}
		}

		for (int i = yPoint; i < N; i++) {
			if (cookie[i][xPoint - 2] == '*') {
				size[3]++;
			}
		}
		for (int i = yPoint; i < N; i++) {
			if (cookie[i][xPoint] == '*') {
				size[4]++;
			}
		}
		System.out.println(yPoint + " " + xPoint);
		System.out.println(size[0] + " " + size[1] + " " + size[2] + " " + size[3] + " " + size[4]);

	}

}