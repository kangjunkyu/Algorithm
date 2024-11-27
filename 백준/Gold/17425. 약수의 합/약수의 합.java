import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int max = 1000001;

		long[] fx = new long[max];
		long[] gx = new long[max];

		Arrays.fill(fx, 1);

		// 약수의 합 구하는 반복문
		for (int i = 2; i < max; i++) {
			for (int j = 1; i * j < max; j++) {
				fx[i*j] += i;
			}
		}
		// 누적합 구하는 반복문
		for (int i = 1; i < max; i++) {
			gx[i] = gx[i - 1] + fx[i];
		}

		for (int i = 0; i < T; i++) {
			System.out.println(gx[Integer.parseInt(br.readLine())]);
		}
	}
}