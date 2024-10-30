import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			double max = 0;
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				double height = Double.parseDouble(st.nextToken());

				if (height < max) {
					continue;
				}
				if (height > max) {
					list = new ArrayList<>();
				}
				list.add(name);
				max = height;
			}
			for (String name : list) {
				sb.append(name).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
}