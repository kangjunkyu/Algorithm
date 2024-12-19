class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // needle이 빈 문자열인 경우 항상 0 반환
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // needle을 찾은 경우 그 위치 반환
            }
        }
        return -1; // 찾지 못한 경우 -1 반환
    }
}
