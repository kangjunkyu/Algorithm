import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for (int i = 1; i < 101; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x] = y;
		}
		
		int ans = dfs(1);
		
		System.out.println(ans);
	}
	private static int dfs(int i) {
		// TODO Auto-generated method stub
		
		int[] check = new int[101];
		Queue<Integer> que = new LinkedList<>();
		que.add(i);
		check[i] = 0;
		
		while(true) {
			int now = que.poll();
			for (int j = 1; j < 7; j++) {
				int next = now + j;
				
				if(next > 100) {
					continue;
				}
				
				if(check[arr[next]]==0) {
					que.add(arr[next]);
					check[arr[next]] = check[now]+1;
				}
				
				if(arr[next] == 100) {
					return check[100];
				}
			}
		}
	}
}