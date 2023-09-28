import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		BigInteger[] arr = new BigInteger[N + 2];

		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;

		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1]);
		}

		if (N == 0) {
			System.out.println(0);
		} else {
			System.out.println(arr[N]);
		}
	}
}