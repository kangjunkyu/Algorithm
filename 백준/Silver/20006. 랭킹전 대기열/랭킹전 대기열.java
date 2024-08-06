import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Player implements Comparable<Player> {
		public Player(int level, String nickname) {
			super();
			this.level = level;
			this.nickname = nickname;
			this.visited = false;
		}

		int level;
		String nickname;
		boolean visited;

		@Override
		public int compareTo(Player o) {
			// TODO Auto-generated method stub
			return this.nickname.compareTo(o.nickname);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Player> list = new ArrayList<>();

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			list.add(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		for (int i = 0; i < P; i++) {
			ArrayList<Player> capacity = new ArrayList<>();
			if (!list.get(i).visited) {
				for (int j = i; j < P; j++) {
					if (capacity.size() == M) {
						break;
					}
					Player player = list.get(j);
					if (!player.visited && list.get(i).level - 10 <= player.level
							&& list.get(i).level + 10 >= player.level) {
						player.visited = true;
						capacity.add(player);
					}
				}
				Collections.sort(capacity);
				if (capacity.size() == M) {
					sb.append("Started!").append("\n");
				} else {
					sb.append("Waiting!").append("\n");
				}
				for (Player player : capacity) {
					sb.append(player.level + " " + player.nickname).append("\n");
				}
			}
		}
		System.out.println(sb);

	}
}