class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(s.charAt(i));
            } else {
                if(stk.isEmpty()){
                    return false;
                }
                char top = stk.pop();
                if((s.charAt(i) == ')' && top != '(')||
                (s.charAt(i) == '}' && top != '{')||
                (s.charAt(i) == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}