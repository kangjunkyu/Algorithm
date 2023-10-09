import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int blank = 10;
	static final int black = -1;
	static final int RainBow = 0;
	static int N, X;
	static int x, y;

	static void solution() throws IOException {
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sum += init(st);
		}
		System.out.println(sum % X == 0 ? 1 : 0);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		X = init(st);
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static boolean index(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N) {
			return true;
		}
		return false;
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}