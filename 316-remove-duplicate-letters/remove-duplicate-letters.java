class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastindex = new int[26];
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        boolean[] inStk = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            lastindex[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            if(inStk[cur - 'a']) continue;

            while(!stk.isEmpty() && stk.peek() > cur && lastindex[stk.peek()-'a'] > i){
                inStk[stk.pop()-'a'] = false;
            }

            stk.push(cur);
            inStk[cur - 'a'] = true;
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        return sb.reverse().toString();

    }
}