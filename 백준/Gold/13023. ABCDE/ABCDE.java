import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] list;
	static boolean[] check;
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];

		//오랜만에 하려니까 헷깔리네.. 걍 리스트안에 리스트넣는게 좋은듯;
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			int friend = Integer.parseInt(st.nextToken());
			list[person].add(friend);
			list[friend].add(person);

		}

		//상태 결과 확인
		possible = false;

		for (int i = 0; i < N; i++) {
			check = new boolean[N];

			dfs(i, 1);

		}
		if (possible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void dfs(int index, int depth) {
	    if (depth == 5) {
	        possible = true;
	        return;
	    }

	    check[index] = true;
	    
	    
	    //forEach로 순회하면서 체크하며 재귀;
	    list[index].forEach(next -> {
	        if (!check[next] && !possible) {
	            dfs(next, depth + 1);
	        }
	    });

	    check[index] = false;
	}

}