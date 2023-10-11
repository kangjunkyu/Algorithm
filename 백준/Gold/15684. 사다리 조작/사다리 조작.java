import java.io.*;
import java.util.*;

public class Main {

	static int N, M, H;
	static int[][] ladder;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 가로선, 세로선, 높이
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		// 2차원 배열 만들어
		ladder = new int[H + 1][N + 1];

		// 각 사다리가 연결이 되어있으면 1로 만들어.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ladder[r][c] = 1;
		}
		
		//사다리를 최대 3개 놓아서 갈 수 있는 경우의 수를 계산하는 거다.
		for (int i = 0; i <= 3; i++) {
			comb(1, 0, i);
		}
		System.out.println(-1);

	}

	static void comb(int nr, int cnt, int size) {
		if (cnt == size) {
			if (check()) {
				System.out.println(size);
				System.exit(0);
			}
			return;
		}

		for (int r = nr; r <= H; r++) {
			for (int c = 1; c < N; c++) {
				//이미 자리가 사다리라면
				if (ladder[r][c] == 1)
					continue;
				//왼쪽에 사다리가 있따면.
				if (ladder[r][c - 1] == 1) {
					continue;
				}
				//오른 쪽에 사다리가 있다면
				if (ladder[r][c + 1] == 1) {
					continue;
				}
				//아니라면 사다리를 놓아준다.
				ladder[r][c] = 1;
				//그러고 cnt를 증가시켜준다.
				comb(r, cnt + 1, size);
				//증가 시켰으면 다시 빼줘야지;
				ladder[r][c] = 0;

			}
		}
	}
	
	//dfs로 돌려...
	static boolean check() {
		//이건 결국 포문을 사다리 개수 만큼 돌면서 확인하는 거다.
		for (int i = 1; i <= N; i++) {
			//현재 위치를 받고, 돌면서 자기 자신이 사다리를 모두 돌았음에도 자기 위치로 돌아온다면  true를 반환하는 것;
			int currPosition = i;
			int start = 1;
			//사다리 높이 만큼 돌려야함
			while (start <= H) {
				//오른쪽에 있다면?
				if (ladder[start][currPosition] == 1) {
					currPosition++;
					start++;
					//왼쪽에 있다면?
				} else if (ladder[start][currPosition - 1] == 1) {
					currPosition--;
					start++;
					//사다리가 없다면?
				} else {
					start++;
				}
			}
			//위치가 자신의 출발 위치와 다르다면 false;
			if (i != currPosition)
				return false;
		}
		//아님 true로 반환해라
		return true;
	}
}