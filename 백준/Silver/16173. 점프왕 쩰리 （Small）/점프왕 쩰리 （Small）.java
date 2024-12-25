
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println("Hing");
	}

	private static void dfs(int i, int j) {
		check[i][j] = true;
		
		if(map[i][j] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		
		for (int k = 0; k < 2; k++) {
			int nx = i + dx[k] * map[i][j];
			int ny = j + dy[k] * map[i][j];
			
			if(nx >= N || ny >= N || check[nx][ny]) {
				continue;
			}
			dfs(nx,ny);
		}
	}
}
