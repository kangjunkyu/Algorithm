import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());
		
		P = (P + T) % (W * 2);
		Q = (Q + T) % (H * 2);
		
		if(P > W) {
			P = W - (P - W);
		}
		if(Q > H) {			
			Q = H - (Q - H);
		}
		
		System.out.println(P+ " " + Q);
	}
}