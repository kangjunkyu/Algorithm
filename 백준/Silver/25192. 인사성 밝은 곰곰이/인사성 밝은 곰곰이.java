import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {

			String str = br.readLine();

			if (str.equals("ENTER")) {
				count += set.size();
				set = new HashSet<>();
			} else {
				set.add(str);
			}
		}
		count += set.size();

		System.out.println(count);
	}
}