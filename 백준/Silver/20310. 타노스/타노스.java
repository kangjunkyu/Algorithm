import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int zero = 0;
		int one = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			sb.append(c);
			if (c == '0') {
				zero += 1;
			} else if (c == '1') {
				one += 1;
			}
		}

		int resZero = zero / 2;
		int resOne = one / 2;

		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '1') {
				sb.setCharAt(i, '2');
				resOne--;
			}
			if(resOne == 0) break;
		}
		
		for (int i = sb.length()-1; i >= 0; i--) {
			if(sb.charAt(i)=='0') {
				sb.setCharAt(i, '2');
				resZero--;
			}
			if(resZero == 0) break;
		}
		
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)=='1' || sb.charAt(i)=='0') {
				System.out.print(sb.charAt(i));
			}
		}
	}
}