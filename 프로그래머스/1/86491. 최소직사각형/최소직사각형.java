class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_width = 0;
        int max_height = 0;
        for(int i = 0; i < sizes.length; i++){
            int x = sizes[i][0];
            int y = sizes[i][1];
            
            int width = Math.max(x, y);
            int height = Math.min(x, y);
            
            max_width = Math.max(width, max_width);
            max_height = Math.max(height, max_height);
            
        }
        
        answer = max_width * max_height;
        return answer;
    }
}