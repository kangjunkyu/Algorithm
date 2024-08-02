import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] picture;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		picture = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = str.charAt(j) - '0';
			}
		}

		checkTree(0, 0, N);
//		System.out.println(sb);

	}

	private static void checkTree(int i, int j, int size) {
		int value = picture[i][j];

		boolean check = true;

		for (int k = i; k < i + size; k++) {
			for (int k2 = j; k2 < j + size; k2++) {
				if (picture[k][k2] != value) {
					check = false;
					break;
				}
			}
			if (!check)
				break;
		}
		if (check) {
			sb.append(value);
			System.out.print(value);
			return;
		}

		sb.append("(");
		System.out.print("(");

		int newSize = size / 2;

		checkTree(i, j, newSize);
		checkTree(i, j + newSize, newSize);
		checkTree(i + newSize, j, newSize);
		checkTree(i + newSize, j + newSize, newSize);

		sb.append(")");
		System.out.print(")");

	}
}