import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Fireball {
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        int r;
        int c;
        int m;
        int s;
        int d;
    }

    static int N, M, K;
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static ArrayList<Fireball>[][] map;
    static ArrayList<Fireball> fireballs = new ArrayList<>(); // 초기화 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            fireballMove(N);
            fireballAction(N);
        }
        
        System.out.println(fireBallCal());
    }

    private static void fireballMove(int n) {
        for (Fireball fb : fireballs) {
            int newR = (fb.r + N + dr[fb.d] * (fb.s % N)) % N;
            int newC = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;
            fb.r = newR;
            fb.c = newC;

            map[newR][newC].add(fb);
        }
    }

    static void fireballAction(int N) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() < 2) {
                    map[r][c].clear();
                    continue;
                }

                int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                int size = map[r][c].size();

                List<Fireball> toRemove = new ArrayList<>();
                for (Fireball cur : map[r][c]) {
                    mSum += cur.m;
                    sSum += cur.s;
                    if (cur.d % 2 == 1)
                        oddCount++;
                    else
                        evenCount++;
                    toRemove.add(cur);
                }

                map[r][c].clear();
                fireballs.removeAll(toRemove);

                mSum /= 5;
                if (mSum == 0) continue;
                sSum /= size;

                if (oddCount == size || evenCount == size) {
                    for (int i = 0; i < 8; i += 2)
                        fireballs.add(new Fireball(r, c, mSum, sSum, i));
                } else {
                    for (int i = 1; i < 8; i += 2)
                        fireballs.add(new Fireball(r, c, mSum, sSum, i));
                }
            }
        }
    }

    static int fireBallCal() {
        int result = 0;
        for (Fireball cur : fireballs)
            result += cur.m;
        return result;
    }
}