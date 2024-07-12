import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int StudentNum = Integer.parseInt(br.readLine());

		int[][] rec = new int[StudentNum][5];

		for (int i = 0; i < StudentNum; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				rec[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int leader = 0;

		for (int i = 0; i < StudentNum; i++) {
			HashSet<Integer> set = new HashSet<>();
			
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < StudentNum; k++) {
					if(rec[i][j] == rec[k][j] && i != k) {
						set.add(k);
					}
				}
			}
			
			if(set.size()>max) {
				leader = i;
				max = set.size();
			}
		}
		System.out.println(leader+1);
	}

}