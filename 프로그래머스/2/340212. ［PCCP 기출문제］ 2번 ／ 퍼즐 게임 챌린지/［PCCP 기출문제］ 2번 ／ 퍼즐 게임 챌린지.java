class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return solve(diffs, times, limit);
    }
    
    static int solve(int[] diffs, int[] times, long limit) {
        int max = 1;
        int min = 100000;
        
        while(max <= min){
            int level = (max + min) / 2;
            long mid = cal(diffs, times, level);
            
            if(mid > limit){
                max = level + 1;
            }else {
                min = level - 1;
            }
        }
        return max;
    }
    static long cal(int[] diffs, int[] times, long level){
        long ans = 0;
        
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] > level){
                ans += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }else{
                ans += times[i];
            }
        }
        return ans;
    }
}