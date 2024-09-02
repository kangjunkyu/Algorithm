import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static char[][] resultMap;
    static int[] dx = {1, 1, 0, 0, 1, -1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 0, 0, 1, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        resultMap = new char[N][N];
        
        //메서드 분리 연습

        // 지도 초기화
        initializeMap(br);

        // 결과 지도 계산
        calculateResultMap();

        // 결과 출력
        printResultMap();
    }

    private static void initializeMap(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] != '.') {
                    resultMap[i][j] = '*'; // 숫자가 있던 곳은 '*'로 표시
                } else {
                    resultMap[i][j] = '.'; // 빈 칸은 초기화
                }
            }
        }
    }

    private static void calculateResultMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    resultMap[i][j] = calculateAdjacentMines(i, j);
                }
            }
        }
    }

    private static char calculateAdjacentMines(int x, int y) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isInBounds(nx, ny) && map[nx][ny] != '.') {
                cnt += map[nx][ny] - '0';
            }
        }
        if (cnt >= 10) {
            return 'M'; // 지뢰가 10개 이상이면 M
        } else {
            return (char) (cnt + '0'); // 지뢰 개수 기록
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void printResultMap() {
        for (int i = 0; i < N; i++) {
            System.out.println(resultMap[i]);
        }
    }
}