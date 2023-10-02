import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] change = new int[N];
		int[] origin = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = change[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(change);

		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();

		int Rank = 0;
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < change.length; i++) {
			if(!rankingMap.containsKey(change[i])) {
				rankingMap.put(change[i], Rank);
				Rank++;
			}
		}
		
		for (int i = 0; i < origin.length; i++) {
			int ranking = rankingMap.get(origin[i]);
//			System.out.print(ranking + " ");
			sb.append(ranking + " ");
		}
		System.out.println(sb);
	}
}