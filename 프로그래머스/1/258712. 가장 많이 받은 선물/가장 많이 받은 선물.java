import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int friendsLength = friends.length;
        
        int[][] giftGraph = new int[friendsLength][friendsLength];
        int[] giftNode = new int[friendsLength];
        
        HashMap<String, Integer> dic = new HashMap<>();
        
        for(int i = 0; i < friendsLength; i++){
            dic.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] item = gift.split(" ");
            giftNode[dic.get(item[0])]++;
            giftNode[dic.get(item[1])]--;
            giftGraph[dic.get(item[0])][dic.get(item[1])]++;
        }
        
        for(int i = 0; i < friendsLength; i++){
            int num = 0;
            for(int j = 0; j < friendsLength; j++){
                if(i == j){
                    continue;
                }
                
                if(giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i]  && giftNode[i] > giftNode[j])){
                    num++;
                }
            }
            answer = Math.max(num, answer);
        }
        return answer;
    }
}