import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Balloon {
    int index;
    int value;

    public Balloon(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        LinkedList<Balloon> balloons = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        int currentIndex = 0;
        while (!balloons.isEmpty()) {
            Balloon currentBalloon = balloons.remove(currentIndex);
            sb.append(currentBalloon.index).append(" ");
            if (balloons.isEmpty()) {
                break;
            }

            int move = currentBalloon.value;
            if (move > 0) {
                currentIndex = (currentIndex + move - 1) % balloons.size();
            } else {
                currentIndex = (currentIndex + move + balloons.size()) % balloons.size();
            }

            // 인덱스가 음수일 때 처리
            if (currentIndex < 0) {
                currentIndex += balloons.size();
            }
        }

        System.out.println(sb.toString().trim());
    }
}