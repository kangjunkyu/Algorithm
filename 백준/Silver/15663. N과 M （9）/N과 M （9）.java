import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int[] arr2;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static HashSet<String> hash = new LinkedHashSet<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		arr2 = new int[M];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		dfs(0);


		for (String vin : hash)
			System.out.println(vin);

	}

	public static void dfs(int count) {
		if (count == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr2[i] + " ");
			}
			hash.add(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr2[count] = arr[i];
				dfs(count + 1);
				visit[i] = false;
			}
		}
	}
}