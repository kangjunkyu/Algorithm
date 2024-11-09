import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, minTime = Integer.MAX_VALUE;
    static int[][] lab;
    static List<Position> virusPositions = new ArrayList<>();
    static Position[] selectedVirus;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virusPositions.add(new Position(i, j));
            }
        }

        selectedVirus = new Position[M];
        chooseVirus(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    static void chooseVirus(int count, int start) {
        if (count == M) {
            spreadVirus();
            return;
        }
        for (int i = start; i < virusPositions.size(); i++) {
            selectedVirus[count] = virusPositions.get(i);
            chooseVirus(count + 1, i + 1);
        }
    }

    static void spreadVirus() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] time = new int[N][N];

        int emptyCells = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] != 1) {
                    emptyCells++;
                    time[i][j] = -1;
                }
            }
        }

        for (Position pos : selectedVirus) {
            queue.add(pos);
            visited[pos.x][pos.y] = true;
            time[pos.x][pos.y] = 0;
        }

        int maxTime = 0;
        int filled = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && lab[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny));
                    time[nx][ny] = time[current.x][current.y] + 1;
                    filled++;
                    maxTime = Math.max(maxTime, time[nx][ny]);
                }
            }
        }

        filled += M;
        
        if (filled == emptyCells) {
            minTime = Math.min(minTime, maxTime);
        }
    }
}