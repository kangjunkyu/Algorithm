class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String [] arr= {"aya", "ye", "woo", "ma"};
        
        for(String bab : babbling){
            for(String a : arr){
                if(bab.contains(a))
                bab = bab.replace(a, " ");
            }
            
            bab= bab.replace(" ", "");
            
            if(bab.equals("")){
                answer++;
            }
        }
        
        return answer;
    }
}