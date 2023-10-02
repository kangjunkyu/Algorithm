import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static boolean check[];
	static int[][] map;
	static ArrayList<Node> person;
	static ArrayList<Node> chicken;
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		// person과 chicken의 크기를 배정해서는 안된다. 밑에 반복문에서 add를 하여 늘려야 size로 측정이 가능하다.
		person = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					person.add(new Node(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		check = new boolean[chicken.size()];
		ans = 987654321;
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int start, int cnt) {
		if (cnt == M) {

			// 최후에 비교하여 ans를 바꿀 값;
			int res = 0;

			for (int i = 0; i < person.size(); i++) {
				//비교해줄 값을 만들어주기 위해 temp라는 임시값을 만들어준다.
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					//check는 방문 배열이 아니다.단지 백트래킹을 하며 조건을 만들기 위한 배열이다.
					if (check[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);

						temp = Math.min(temp, distance);
					}
				}
				//괄호 체크 잘합시다..
				res += temp;
			}
			ans = Math.min(ans, res);
			return;
		}

		//걍 M으로 했다가 틀림..
		//start로 바꾸자.. 아니 근데 킹받네 왜 0은 안되냐
		for (int i = start; i <check.length; i++) {
			check[i] = true;
			dfs(i + 1, cnt + 1);
			check[i] = false;
		}
	}
}