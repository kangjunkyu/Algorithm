import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        int V = Integer.parseInt(st.nextToken())-1;
	        int[] arr = new int[N + 1];
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }

	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < M; i++) {
	            int num = Integer.parseInt(br.readLine())+1;
	            if (num <= N) {
	                sb.append(arr[num]).append("\n");
	            } else {
	                int tmp = (num - (V)) % (N - (V));
	                if (tmp == 0) {
	                    sb.append(arr[N]).append("\n");
	                } else {
	                    sb.append(arr[tmp + (V)]).append("\n");
	                }
	            }
	        }

	        System.out.print(sb);

	    }
}