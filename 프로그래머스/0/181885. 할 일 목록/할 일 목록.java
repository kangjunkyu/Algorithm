import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < finished.length; i++){
            if(!finished[i]){
                list.add(todo_list[i]);
            }
        }
        String[] answer = new String[list.size()];
        answer = list.toArray(answer);
        return answer;
    }
}