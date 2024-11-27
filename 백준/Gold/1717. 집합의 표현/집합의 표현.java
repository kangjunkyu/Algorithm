import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parents;

	private static void make() {

		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return parents[a];
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (k == 0) {
				union(a, b);
			} else if (k == 1) {
				if (find(a) == find(b)) {
					sb.append("YES");
					sb.append("\n");
				} else {
					sb.append("NO");
					sb.append("\n");
				}
			}

		}

		System.out.println(sb);
		br.close();
	}

}