import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cX = Integer.parseInt(st.nextToken());
                int cY = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                if ((isCheck(cX, cY, R, startX, startY) && !isCheck(cX, cY, R, endX, endY)) ||
                    (!isCheck(cX, cY, R, startX, startY) && isCheck(cX, cY, R, endX, endY))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isCheck(int cX, int cY, int r, int x, int y) {
        return Math.pow(x - cX, 2) + Math.pow(y - cY, 2) < Math.pow(r, 2);
    }
}