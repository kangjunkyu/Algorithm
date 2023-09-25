import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] check;
	static int K, cnt, result;

	// 따로 노드를 만들지 않아도 주어진 위치가 아닌 모두 탐색한 경우의 수를 출력하기에 괜찮다.
//	static class Node {
//		int x;
//		int y;
//		int cnt;
//
//		public Node(int x, int y, int cnt) {
//			super();
//			this.x = x;
//			this.y = y;
//			this.cnt = cnt;
//		}
//
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		
		//맵의 크기는 고정이다.
		map = new int[5][5];
		check = new boolean[5][5];

		//움직이지 못하는 곳은 -1로 받자.
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			map[x][y] = -1;
		}


		bfs(0, 0, 1);

		System.out.println(result);
	}

	static void bfs(int x, int y, int cnt) {
	    if (x == 4 && y == 4) {
	        if (cnt == 25 - K) {
	            result++;
	        }
	        return;
	    }

	    // 현재 셀을 방문했음을 확인하자
	    check[y][x] = true;

	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        // 새로운 위치(nx, ny)가 배열의 범위 내에 있고, 방문하지 않았으며 장애물이 아닌지 확인하
	        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !check[ny][nx] && map[ny][nx] != -1) {
	            bfs(nx, ny, cnt + 1);
	        }
	    }

	    // 방문체크 해제하자
	    check[y][x] = false;
	}

}