import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		long pipe = 0;
	
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pipe += arr[i];
		}
		
//		System.out.println("pipe : " + pipe);
		
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			pipe -= temp;
//			System.out.println(i + " pipe : " + pipe);
			result += temp * pipe;
//			System.out.println(i + " result : " + result);
		}
		
		System.out.println(result);
		
	}
}