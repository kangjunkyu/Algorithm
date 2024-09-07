import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        int[] answer = new int[T]; // 한번에 출력하기 위한 배열

        for (int i = 0; i < T; i++) { // 테스트 케이스 반복
            int N = Integer.parseInt(br.readLine()); // 선수 수
            int[] ranks = new int[N]; // 각 선수의 팀 번호
            Map<Integer, Integer> countMap = new HashMap<>(); // 팀별 인원 수 체크
            st = new StringTokenizer(br.readLine());
            int maxTeam = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                countMap.put(team, countMap.getOrDefault(team, 0) + 1); // 해당 팀의 인원 체크
                ranks[j] = team; // 각 등수의 팀
                maxTeam = Math.max(maxTeam, team); // 가장 큰 번호의 팀 찾기
            }

            int[] fifthPlayer = new int[maxTeam + 1]; // 5번째 주자의 순위 저장
            Map<Integer, Integer> scoreMap = new HashMap<>(); // 팀별 점수 저장
            Map<Integer, Integer> tmpMap = new HashMap<>(); // 각 팀별 주자의 순위 체크
            int score = 1; // 각 주자의 순위

            // 각 선수의 순위를 확인하면서 점수 계산
            for (int rank : ranks) {
                if (countMap.get(rank) == 6) { // 팀원이 6명인 팀만 점수 계산
                    tmpMap.put(rank, tmpMap.getOrDefault(rank, 0) + 1);

                    if (tmpMap.get(rank) <= 4) { // 상위 4명만 점수 계산
                        scoreMap.put(rank, scoreMap.getOrDefault(rank, 0) + score);
                    }

                    if (tmpMap.get(rank) == 5) { // 다섯 번째 주자
                        fifthPlayer[rank] = score;
                    }

                    score++; // 다음 선수의 순위 증가 == 점수는 순위에 따라 1씩 증가한다.
                }
            }

            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            for (Integer team : scoreMap.keySet()) {
                int teamScore = scoreMap.get(team);
                if (teamScore < result) { // 점수가 더 낮은 팀이 우승
                    result = teamScore;
                    fifthScore = fifthPlayer[team];
                    answer[i] = team;
                } else if (teamScore == result) { // 점수가 동점일 경우 5번째 주자의 점수 비교
                    if (fifthScore > fifthPlayer[team]) {
                        answer[i] = team;
                    }
                }
            }
        }

        for (int ans : answer) {
        	sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}