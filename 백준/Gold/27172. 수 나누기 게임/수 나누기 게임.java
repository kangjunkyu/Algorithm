import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int max = 1000001;
		int[] card = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, card[i]);
		}
		
		boolean[] check = new boolean[max];
		int[] score = new int[max];
		
		for (int i = 0; i < N; i++) {			
			check[card[i]] = true;
		}
		
		for (int i : card) {
			for (int j = i * 2; j < max; j += i) {
				if(check[j]) {
					++score[i];
					--score[j];
				}
			}
		}
		for(int people : card) {
			sb.append(score[people]).append(" ");
		}
		System.out.println(sb);
	}
}