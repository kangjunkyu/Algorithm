import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String S, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();

		System.out.println(dfs(S, T) ? 1:0);
	}
	private static boolean dfs(String s2, String t2) {
		if(s2.length() == t2.length()) {
			if(s2.equals(t2)) {
				return true;
			}
		}
		boolean ans = false;
		
		if(t2.length() > 0 && t2.charAt(0) == 'B') {
			String sub = t2.substring(1);
			StringBuilder sb = new StringBuilder(sub);
			String str = sb.reverse().toString();
			ans = dfs(s2, str);
		}
		
		if(t2.length() > 0 && t2.charAt(t2.length()-1) == 'A') {
			ans =ans || dfs(s2, t2.substring(0, t2.length()-1));
		}
		
		return ans;
	}
}
