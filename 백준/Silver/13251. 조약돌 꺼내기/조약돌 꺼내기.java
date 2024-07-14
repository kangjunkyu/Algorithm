import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stone = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int whole = 0;
		
		for (int i = 0; i < N; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
			whole += stone[i];
		}
		
		int K = Integer.parseInt(br.readLine());
		
		double ans = 0;
		
		for (int i = 0; i < N; i++) {
			double value = 1;
			for (int j = 0; j < K; j++) {
				value *= (double)(stone[i] - j) / (whole-j);
			}
			ans += value;
		}
		System.out.println(ans);
	}
}