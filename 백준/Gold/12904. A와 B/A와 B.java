import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		String S = br.readLine();
		String T = br.readLine();
		
		//오래걸렸다.. 이거 T를 기준으로 잡아야 풀 수 있던 문제였다...
		while(S.length() < T.length()) {
			char lastIndex = T.charAt(T.length()-1);
			if(lastIndex == 'A') {
				T = T.substring(0, T.length()-1);
			}else {
				T = T.substring(0, T.length()-1);
				T = reverseFunction(T);
			}
		}
		
		if(S.equals(T)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
    private static String reverseFunction(String str) {
        StringBuilder reversed = new StringBuilder();
        // 문자열을 뒤에서부터 앞으로 추가
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}