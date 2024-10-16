import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String action = st.nextToken();
			
			if(action.equals("enter")) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		for(String ans : list) {
			System.out.println(ans);
		}
		
	}
}