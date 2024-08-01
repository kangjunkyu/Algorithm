import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (true) {
            input = br.readLine();

            if (input == null) {
                break;
            }

            int num = Integer.parseInt(input.trim());

            int ans = find(num);

            System.out.printf("%5d -> %d\n", num, ans);
        }
    }

    // 팩토리얼 계산 중 마지막 0이 아닌 숫자 추적
    private static int find(int num) {
        int ans = 1; // 초기화
        long factorial = 1; // 계산을 위한 변수

        for (int i = 2; i <= num; i++) {
            factorial *= i;

            // 0을 제거하고 마지막 0이 아닌 숫자만 남기기
            while (factorial % 10 == 0) {
                factorial /= 10;
            }

            factorial %= 100000;

            //마지막 숫자 구하기 
            ans = (int) (factorial % 10);
        }

        return ans;
    }
}