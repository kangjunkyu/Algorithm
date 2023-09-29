import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 필요한 건 2개다.
	//1. 지역구가 2개로 나뉘어질 것, 이건 bfs를 통해 체크할 것이다.
	//2. 지역구가 2개로 나뉘었을 때, 각 지역구의 값을 체크하고 더할 수 있게 할 dfs가 필요하다.
	//필요한 배열은 총 3개이며 각 지역구의 넘버를 저장할 배열과, 방문체크를 할 배열, 인구수를 체크할 배열이 필요하다.
	// 리스트는 배열로 만들어 que에서 유동적으로 사용할 수 있게끔한다.
	

	static int N;
	static int[] population, area;
	static ArrayList<Integer>[] list;
	static int min = Integer.MAX_VALUE;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		area = new int[N + 1];
		list = new ArrayList[N + 1];
		
		//인구수와 각 지역에 선거구를 저장할 배열을 만들어준다.
		//리스트도 써야하니까 만들어줭~~

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 리스트에 리스트를 넣어주고, 인구수에 대한 저장
			list[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			//각 지역이 연결되어 있는 내용에 대한 간선 저장
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//dfs를 돌려 선거구가 2개로 나뉘어지는지 확인하고, 그 안에서 bfs도 돌릴거양
		dfs(1);
		
		//만약 이어져있지않다면 01을 출력하고, 아니면 최소한의 차이로 출력할 수 있게 한다.
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}

	static void dfs(int k) {
		
		//카운트가N+1에 도달한다면, 왜냐? 1부터 시작하니까 전체적으로 배열이 1부터 들어가있어
		if (k == N + 1) {
			int area1 = 0;
			int area2 = 0;
			//배열에서 나온 값이 1 혹은 2냐에 따라 선거구 인구 저장값에 더해준다.
			for (int i = 1; i <= N; i++) {
				if (area[i] == 1) {
					area1 += population[i];
				} else {
					area2 += population[i];
				}
			}

			check = new boolean[N + 1];

			//방문배열을 생성해주고, 만약 방문하지 않았다면 링크를 더해준다.
			int link = 0;
			for (int i = 1; i <= N; i++) {
				if (!check[i]) {
					//중요한건 이 상황에 bfs를 돌려야 한다는 것.
					bfs(i, area[i]);
					link++;
				}
			}
			if (link == 2) {
				//나누어 진다면 min값에 대한 수정
				min = Math.min(min, Math.abs(area1 - area2));
			}
			return;

		}

		//위 작업을 모두 돌리고 k가 N+1에 도달한다면 리턴을 할 것이다.
		area[k] = 1;
		dfs(k + 1);
		area[k] = 2;
		dfs(k + 1);
	}
	
	static void bfs(int idx, int areaNum) {
		Queue<Integer> que = new LinkedList<>();
		//큐를 만들고 받은 인덱스 값에 대해 방문체크를 해준 뒤에 큐에 넣어준다.
		check[idx] = true;
		que.offer(idx);
		//bfs를 돌려준다.
		while(!que.isEmpty()) {
			int now = que.poll();
			
			//리스트에 연결되어 있는 간선에 대하여 그만큼의 길이만큼 que에 담에 돌려준다.
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(area[next] == areaNum && !check[next]) {
					que.offer(next);
					check[next] = true;
				}
			}
		}
	}
}