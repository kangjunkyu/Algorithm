class Solution {
    public String solution(String my_string) {
        String answer = "";
        int len = my_string.length();
        // System.out.println(len);
        char[] list = new char[len];
        char[] reverse = new char[len];
        
        for(int i = 0; i<len; i++){
            list[i] = my_string.charAt(i);
        }
        int start = 0;
        for(int i = len-1; i >= 0; i--){
            
            reverse[start++] = list[i];
        }
        answer = new String(reverse);
        return answer;
    }
}