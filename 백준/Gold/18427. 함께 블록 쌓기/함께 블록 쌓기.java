import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	static int N, M, H;
	static List<Integer>[] block;
	static int[] before;
	static int[] after;
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		block = new List[N];
		
		before = new int[H+1];
		after = new int[H+1];
		
		for (int i = 0; i < N; i++) {
			block[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				block[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int num : block[i]) {
				after[num] += 1;
				
				for (int j = 0; j < H+1; j++) {
					if(j - num > 0) {
						after[j]+= before[j - num] % 10007;
					}
				}
			}
			for (int j = 0; j < H+1; j++) {
				before[j] = after[j];
			}
		}
		System.out.println(before[H] % 10007);
		
	}
}
