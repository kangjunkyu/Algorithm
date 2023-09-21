import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count=0;
	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2,N);
		
		check(size, r, c);

		System.out.println(count);
	}

	public static void check(int size, int r, int c) {
		if (size == 1) {
			return;
		}

		if (r < size / 2 && c < size / 2) {
			check(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) {
			count += size * size / 4;
			check(size / 2, r, c-size/2);
		} else if (r >= size / 2 && c < size / 2) {
			count += (size * size / 4) * 2;
			check(size / 2, r-size/2, c);
		} else {
			count += (size * size / 4) * 3;
			check(size / 2, r-size/2, c-size/2);
		}
	}
}