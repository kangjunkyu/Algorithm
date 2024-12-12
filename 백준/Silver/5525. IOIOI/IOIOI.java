import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		char[] arr = br.readLine().toCharArray();
		int count = 0, ans = 0;

		for (int i = 1; i < M-1; i++) {
			if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
				count++;
				if (count == N) {
					ans++;
					count--;
				}
                i++;
			}else {
				count = 0;
			}
		}
		System.out.println(ans);
	}
}
