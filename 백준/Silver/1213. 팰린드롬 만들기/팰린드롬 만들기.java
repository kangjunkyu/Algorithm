import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'A';
			arr[idx]++;
		}
		int impossible = 0;
		for (int i = 0; i < arr.length; i++) {
			//만약 1개가 남는게 존재한다면 임파서블을 ++해준다.
			if (arr[i] % 2 != 0) {
				impossible++;
			}
		}

		String ans = "";
		StringBuilder sb = new StringBuilder();
		
		//이게 하나 남은게 하나면 가운데 넣으면 되니까 펠린드롬이 된다.. 생각이 짧았다.. boolean 으로 못
		if (impossible > 1) {
			ans += "I'm Sorry Hansoo";
		} else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i] / 2; j++) {
					// 배열 절반 만큼 비교를 해서 sb로 추가해준다.
					sb.append((char) (i + 65));
				}
			}
			ans += sb.toString();
			//반대로 해서붙여준다.
			String end = sb.reverse().toString();

			//여기서 초기화를 하는 이유는 가운데 들어갈 거를 넣을 수 있게하기 위함임.
			sb = new StringBuilder();

			for (int i = 0; i < arr.length; i++) {
				// 하나만 남은게 있네? 그럼 sb로 넣어
				if (arr[i] % 2 == 1) {
					sb.append((char) (i + 65));
				}
			}
			//그걸 다 붙이면 완성!!
			ans += sb.toString() + end;
		}
		System.out.println(ans);
	}
}