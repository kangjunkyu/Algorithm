class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        int res = num1 - num2;
        
        if(res == 0){
            answer = 1;
        } else{
            answer = -1;
        }
        return answer;
    }
}