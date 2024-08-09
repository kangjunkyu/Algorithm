import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int L, H;

		public Node(int l, int h) {
			L = l;
			H = h;
		}

		@Override
		public int compareTo(Node o) {
			return this.L - o.L;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			list.add(new Node(L, H));
		}

		Collections.sort(list);

		//가장 높은 곳의 높이와 인덱스
		int maxIndex = 0;
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i).H > maxHeight) {
				maxHeight = list.get(i).H;
				maxIndex = i;
			}
		}

		int size = 0;

		// 왼쪽에서부터 최대 높이까지의 면적 계산
		int currentIndex = 0;
		for (int i = 0; i <= maxIndex; i++) {
			if (list.get(currentIndex).H <= list.get(i).H) {
				size += (list.get(i).L - list.get(currentIndex).L) * list.get(currentIndex).H;
				currentIndex = i;
			}

		}

		// 오른쪽에서부터 최대 높이까지의 면적 계산
		currentIndex = N - 1;
		for (int i = N - 1; i >= maxIndex; i--) {
			if (list.get(currentIndex).H <= list.get(i).H) {
				size += (list.get(currentIndex).L - list.get(i).L) * list.get(currentIndex).H;
				currentIndex = i;
			}
		}

		size += list.get(maxIndex).H;

		System.out.println(size);
	}
}