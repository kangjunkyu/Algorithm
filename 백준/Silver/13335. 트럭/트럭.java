import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i< n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		int time = 0; 
		int bw=0;
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i =0; i<w ; i++) {
			que.add(0);
		}
		while(!que.isEmpty()) {
			time++;
			bw-=que.poll();
			if(!truck.isEmpty()) {
				if(truck.peek()+bw<=L) {
					int tep = truck.poll();
					bw+=tep;
					que.offer(tep);
				}else {
					que.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}