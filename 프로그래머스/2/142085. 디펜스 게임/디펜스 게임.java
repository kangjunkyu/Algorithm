import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = enemy.length;
        int N = n;
        int K = k;
        
        for(int i = 0; i < enemy.length; i++){
            N-=enemy[i];
            pq.add(enemy[i]);
            
            if(N < 0){
                if(K > 0 && !pq.isEmpty()){
                    N += pq.poll();
                    K--;
                }else{
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}