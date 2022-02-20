class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int repeat = 0;
        for(int i = 0; i < s.length(); i++) {
            for(char c = 'z'; c >= 'a'; c--) {
                if(count[c - 'a'] > 0) {
                   if(sb.length() > 0 && sb.charAt(sb.length() - 1) != c) {
                        repeat = 0;
                        if(repeat == repeatLimit) {
                            continue;
                        }
                   } 
                    if(repeat < repeatLimit) {
                        sb.append(c);
                        repeat++;
                        count[c - 'a']--;
                        break;
                    } 
                }
            }
        }
        return sb.toString();
    }
}