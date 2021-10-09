class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int len = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            set = new HashSet<>();
            set.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++) {
                if(set.contains(s.charAt(j))) {
                    len = Math.max(len, j - i);
                    break;
                }
                set.add(s.charAt(j));
                if(j == s.length() - 1) return Math.max(len, j + 1 - i);
            }
            
        }
        
        return len;
    }
}