import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dr = {-1, 0, 1, 0 };
    static int[] dc = {0, 1, 0, -1};
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
//                                dp[i][j] = -1;
            }
        }
        dp= new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = -1;
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        bw.write(DFS(1,1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int DFS(int x, int y) {
        if(x ==N && y ==M){
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
//        System.out.println(123);

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if(nx < 1 || ny < 1 || nx > N || ny > M){
                continue;
            }

            if(arr[x][y] > arr[nx][ny]){
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }
}