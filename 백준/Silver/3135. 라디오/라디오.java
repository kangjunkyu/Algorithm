import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int min = Math.abs(B - A);

		for (int i = 0; i < N; i++) {
			int find = Integer.parseInt(br.readLine());

			min = Math.min(Math.abs(find - B) + 1, min);
		}

		System.out.println(min);
	}
}