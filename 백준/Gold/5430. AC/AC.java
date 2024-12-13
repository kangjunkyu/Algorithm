
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String command = br.readLine();

			int num = Integer.parseInt(br.readLine());

			deque = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), "[] ,");

			for (int i = 0; i < num; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			solve(command, deque);

		}
		System.out.println(sb);

	}

	private static void solve(String command, Deque<Integer> deque) {

		boolean dir = true;

		char[] cmd = command.toCharArray();

		for (char c : cmd) {
			if (c == 'R') {
				dir = !dir;
				continue;
			}

			else if (c == 'D') {
				if (dir) {
					if (deque.pollFirst() == null) {
						sb.append("error\n");
						return;
					}
				} else {
					if (deque.pollLast() == null) {
						sb.append("error\n");
						return;
					}
				}
			}
		}
		
		makeAns(deque, dir);
	}

	private static void makeAns(Deque<Integer> deque, boolean dir) {
		
		sb.append('[');
		if(deque.size() > 0) {
			if(dir) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append('\n');
	}
}
