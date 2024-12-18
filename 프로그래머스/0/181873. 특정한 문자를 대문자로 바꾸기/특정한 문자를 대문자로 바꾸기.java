class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        char[] str = my_string.toCharArray();
        char target=  alp.charAt(0);
        
        for(int i = 0; i < str.length; i++){
            if(str[i] == target){
                str[i] = Character.toUpperCase(str[i]);
            }
        }
        
        
        return new String(str);
    }
}