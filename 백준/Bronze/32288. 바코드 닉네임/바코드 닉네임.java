import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			
			if(ch == 'l') {
				System.out.print("L");
			}else {
				System.out.print("i");
			}
		}
	}
}