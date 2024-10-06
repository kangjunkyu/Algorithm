import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int pointer = 0;
		
		int base = 0;
		
		while(base++ <= 30000) {
			String tmp = String.valueOf(base);
			for (int i = 0; i < tmp.length(); i++) {
				if(str.charAt(pointer) == tmp.charAt(i)) {
//					System.out.println("str : " + str.charAt(pointer) + " tmp : " + tmp.charAt(i));
//					System.out.println("base : " + base);
//					System.out.println("pointer : " + pointer);
					pointer++;
				}
				if(pointer == str.length()) {
					System.out.println(base);
//					System.out.println("last pointer : " + pointer);
					return;
				}
			}
		}
	}
}