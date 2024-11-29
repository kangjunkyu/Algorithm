import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N, M, P;
	static boolean[] check;
	static ArrayList<Integer>[] list;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());

		int[] people = new int[P];
		for (int i = 0; i < P; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int first = list[i].get(0);
			for (int j = 1; j < list[i].size(); j++) {
				union(first, list[i].get(j));
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int leader = list[i].get(0);
			boolean flag = true;

			for (int j = 0; j < P; j++) {
				if (find(people[j]) == find(leader)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);

		if (i != j) {
			parent[j] = i;
		}
	}

}