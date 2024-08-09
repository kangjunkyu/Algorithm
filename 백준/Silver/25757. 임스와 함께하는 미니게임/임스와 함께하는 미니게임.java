import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		int people = 0;

		if (game.equals("Y")) {
			people = 1;
		} else if (game.equals("F")) {
			people = 2;
		} else {
			people = 3;
		}
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int ans = set.size()/people;
		
		System.out.println(ans);

	}
}