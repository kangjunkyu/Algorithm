import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 사람수
        int N = Integer.parseInt(st.nextToken()); // 과자수
        int[] L = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0; // 이분탐색용 최대값
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, L[i]);
        }

        System.out.println(binarySearch(L, M, 1, max));;
    }

    public static int binarySearch(int[] L, int M, int left, int right) {
        int result = 0;
        //이분탐색
        while (left <= right) {
            //중간값
            int mid =  left + (right - left) / 2;
            //놔눠줄 수 있는 과자의 개수
            int cnt = 0;

            for (int i = 0; i < L.length; i++) {
            	// 과자의 길이를 나누어 나오는 갯수 파악
                // 이거 해보면 1 이상이 나와야 +가 되니까 파악이 가능하다
                cnt += L[i] / mid;
            }

            if (cnt >= M) {
            	// 위에서 나눈 갯수가 조키수보다 같거나 많을 경우
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}