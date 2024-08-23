import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	//10개월만에 리벤지매치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        st = new StringTokenizer(br.readLine());

        // 값을 입력받아놓고
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp는 채워야지
        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
        	//카페인 값;
            int target = arr[i];
            for (int j = k; j >= target; j--) {
                if (dp[j - target] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - target] + 1);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}