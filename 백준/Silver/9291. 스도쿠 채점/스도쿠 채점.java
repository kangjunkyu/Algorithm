import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int[] dx = { 0, 0, 0, 3, 3, 3, 6, 6, 6 };
	static int[] dy = { 0, 3, 6, 0, 3, 6, 0, 3, 6 };
	static int[][] board;
	static boolean[] number;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		st =  new StringTokenizer(br.readLine());

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			board = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(T != t) {
				br.readLine();
			}
			
			if(check()) {
				System.out.println("Case " + t + ": CORRECT");
			}else if(!check()) {
				System.out.println("Case " + t + ": INCORRECT");
			}
			

		}

	}

	private static boolean check() {
		
		for (int i = 0; i < 9; i++) {
		number = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if(number[board[i][j]]) {
					return false;
				}else {
					number[board[i][j]] = true;
				}
			}
		number = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if(number[board[j][i]]) {
					return false;
				}else {
					number[board[j][i]] = true;
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			boolean[] number = new boolean[10];
			for (int j = dx[i]; j < dx[i]+3; j++) {
				for (int j2 = dy[i]; j2 < dy[i]+3; j2++) {
					if(number[board[j][j2]]) {
						return false;
					}else {
						number[board[j][j2]] = true;
					}
				}
			}
		}
		
		return true;
	}
}