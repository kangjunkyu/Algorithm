import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;

		// 양 옆은 포함시킬 필요가 없다.
		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;

			//보면 가장 높은 위치를 찾는다. 그게 ㅣeft가 될테니, 하지만 i로 범위를 정했으니 결국 해당 칸에 맞는 높이일 것
			for (int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}
			// 오른 위치에 더 높은 곳을 찾는 것이다. 무조건 i의 오른쪽일테니
			for (int j = i + 1; j < W; j++) {
				right = Math.max(arr[j], right);
			}
			// 이건 보면 안다.. 뭐.. 높은 위치를 찾았을 테니 그 값에서 혼재 블록의 높이를 빼면 되는거다.
			if (arr[i] < left && arr[i] < right) {
				result += Math.min(left, right) - arr[i];
			}
		}
		System.out.println(result);
	}
}