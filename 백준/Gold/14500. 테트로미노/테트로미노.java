import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static boolean[][] check;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = true;
                solve(i, j, 1, map[i][j]);  // 시작할 때 카운트를 1로, 초기 셀 값으로 sum 사용
                check[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void solve(int i, int j, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny]) {
                continue;
            }
            
            if(cnt ==2) {
            	check[nx][ny] = true;
            	solve(i, j, cnt +1, sum + map[nx][ny]);
            	check[nx][ny] = false;
            }
            check[nx][ny] = true;
            solve(nx, ny, cnt + 1, sum + map[nx][ny]);
            check[nx][ny] = false;
        }
    }
}