import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int prime[];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		check = new boolean[N+1];
		
		getPrime();
		
		for (int i = M; i <= N; i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}
	}

	private static void getPrime() {

		check[0] = true;
		check[1] = true;
		
		for (int i = 2; i <= Math.sqrt(check.length); i++) {
			if(check[i]) {
				continue;
			}
			for (int j = i*i; j < check.length; j+=i) {
				check[j] = true;
			}
		}
	}
}