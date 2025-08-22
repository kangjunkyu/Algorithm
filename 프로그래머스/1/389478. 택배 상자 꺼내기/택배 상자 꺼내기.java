class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int level = num / w;

        if (num % w == 0) level--;

        int ori_level = level % 2;

        int tmp = (num + (w - 1)) - ((num + (w - 1)) % w);
        int gap = (tmp - num) * 2 + 1;

        while(num <= n){
            answer++;
            if (level % 2 == ori_level) num += gap;
            else num += (w * 2) - gap;
            level++;
        }

        return answer;
    }
}
