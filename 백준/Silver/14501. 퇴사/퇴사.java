import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxProfit;
	static int[][] timetable;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		timetable = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			timetable[i][0] = Integer.parseInt(st.nextToken());
			timetable[i][1] = Integer.parseInt(st.nextToken());

		}

		maxProfit = 0;

		dfs(0, 0);

		System.out.println(maxProfit);
	}

	private static void dfs(int date, int profit) {
		// TODO Auto-generated method stub
		if (date >= N) {
			maxProfit = Math.max(maxProfit, profit);
			return;
		}

		if (date + timetable[date][0] <= N) {
			dfs(date + timetable[date][0], profit + timetable[date][1]);
		} else {
			dfs(date + timetable[date][0], profit);
		}
		dfs(date + 1, profit);
	}
}
