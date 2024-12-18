import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int row = park.length;
        int col = park[0].length;

        Arrays.sort(mats); // 가장 큰 돗자리부터 확인하기 위해 정렬
        int max = -1;

        // 가장 큰 돗자리부터 시도
        for (int t = mats.length - 1; t >= 0; t--) {
            int size = mats[t];
            boolean found = false;

            // park를 순회하며 size x size 크기의 공간 검사
            for (int i = 0; i <= row - size; i++) {
                for (int j = 0; j <= col - size; j++) {
                    boolean check = true;
                    // size x size 내에 "-1" 이외의 문자가 있는지 확인
                    for (int x = i; x < i + size && check; x++) {
                        for (int y = j; y < j + size; y++) {
                            if (!park[x][y].equals("-1")) {
                                check = false;
                                break;
                            }
                        }
                    }

                    if (check) {
                        max = size;
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (max != -1) break;
        }

        return max;
    }
}
