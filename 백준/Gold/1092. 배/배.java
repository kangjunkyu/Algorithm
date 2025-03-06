import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>machin = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			machin.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>box = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		machin.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());
		
		if(machin.get(0) < box.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int day = 0;
		while(!box.isEmpty()) {
			int boxidx = 0;
			int machinidx = 0;
			
			while(machinidx < N) {
				if(boxidx == box.size()) {
					break;
				}else if(machin.get(machinidx) >= box.get(boxidx)){
					box.remove(boxidx);
					machinidx++;
				}else {
					boxidx++;
				}
			}
			day++;
		}
		System.out.println(day);
		
	}
}
