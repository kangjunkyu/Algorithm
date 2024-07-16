import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//deque의 방법은 LinkendList와 ArrayList로 나뉘는데 Link가 편함
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int[] idx = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			idx[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int i = 0; i < M; i++) {
			//deque 로 해서 target 좌표 찾는 로직이 필
			int target = idx[i];

			// 타겟 위치를 찾기 위한 index
			int targetIndex = 0;
			for (Integer num : deque) {
				if (num == target) {
					break;
				}
				targetIndex++;
			}

			// 절반의 위치 계산
			int half = deque.size() / 2;

			if (targetIndex <= half) {
				// 왼쪽으로 회전
				for (int j = 0; j < targetIndex; j++) {
					int temp = deque.pollFirst();
					deque.addLast(temp);
					count++;
				}
			} else {
				// 오른쪽으로 회전
				for (int j = 0; j < deque.size() - targetIndex; j++) {
					int temp = deque.pollLast();
					deque.addFirst(temp);
					count++;
				}
			}

			// 타겟을 꺼냄
			deque.pollFirst();
		}
		System.out.println(count);
	}
}