class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        
        for (int i=0; i<schedules.length; i++) {
            schedules[i] = calc(schedules[i]) + 10;
            int start = startday;
            boolean flag = true;
            for (int j=0; j<timelogs[i].length; j++) {
                if (schedules[i] < calc(timelogs[i][j]) && start != 6 && start != 7) {
                    flag = false;
                    break;
                }
                if (start == 7) start = 1;
                else start++;
            }
            if (flag) answer++;
        }
        
        
        return answer;
    }
    
    int calc(int time) {
        int hour = time / 100;
        int min = time % 100;
        return hour*60 + min;
    }
}