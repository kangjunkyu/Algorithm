import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if(check(word) == true) {
				count+=1;
			}
		}
		System.out.println(count);
	}

	private static boolean check(String word) {
		boolean[] arr = new boolean[26];
		
		int len = word.length();
		int prev = 0;
		for (int i = 0; i < len; i++) {
			int now = word.charAt(i);
			
			if(prev != now) {				
				if(arr[now - 'a'] == false) {
					arr[now - 'a'] = true;
					prev = now;
				}
				else {
					return false;
				}
			}else {
				continue;
			}
		}
		return true;
	}
}
