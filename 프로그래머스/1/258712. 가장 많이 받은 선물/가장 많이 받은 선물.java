import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendLength = friends.length;
        int[] giftDegree = new int[friendLength];
        int[][] giftGraph = new int[friendLength][friendLength];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < friendLength; i++){
            map.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] giftName = gift.split(" ");
            giftDegree[map.get(giftName[0])]++;
            giftDegree[map.get(giftName[1])]--;
            giftGraph[map.get(giftName[0])][map.get(giftName[1])]++;
        }
        
        for(int i = 0; i < friendLength; i++){
            int num = 0;
            for(int j = 0; j < friendLength; j++){
                if(i == j){
                    continue;
                }
                
                if(giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])){
                    num++;
                }
            }
            
            if(answer < num){
                answer = num;
            }
        }
        return answer;
    }
}