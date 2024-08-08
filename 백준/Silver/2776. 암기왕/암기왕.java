import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());

            int[] note1 = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            Arrays.sort(note1);

            for (int j = 0; j < M; j++) {
                int find = Integer.parseInt(st.nextToken());
                int start = 0;
                int end = N - 1;
                boolean check = false;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (note1[mid] < find) {
                        start = mid + 1;
                    } else if (note1[mid] > find) {
                        end = mid - 1;
                    } else {
                        check = true;
                        break;
                    }
                }

                sb.append(check ? 1 : 0).append('\n');
            }
            System.out.print(sb.toString());
        }
    }
}