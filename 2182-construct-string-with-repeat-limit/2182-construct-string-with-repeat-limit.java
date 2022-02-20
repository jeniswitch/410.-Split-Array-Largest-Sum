class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        dfs(count, repeatLimit, 0, sb);
        return sb.toString();
    }
    private boolean dfs(int[] count, int repeatLimit, int repeat, StringBuilder sb) {
        for(char c = 'z'; c >= 'a'; c--) {
            int idx = c - 'a';
            if(count[idx] > 0) {
                if(sb.length() == 0 || sb.charAt(sb.length() - 1) == c) {
                    repeat++;
                }
                else {
                    repeat = 1;
                }
                if(repeat <= repeatLimit) {
                    count[c - 'a']--;
                    sb.append(c);
                    if(dfs(count, repeatLimit, repeat, sb)) {
                        return true;
                    }
                    sb.setLength(sb.length() - 1);
                    count[c - 'a']++;
                }
                /*else if(c != 'a') {
                    repeat = 0;
                }
                else {
                    while(repeat < repeatLimit) {
                        sb.append(c);
                        repeat++;
                    }
                }*/
                
            }
        }
        return true;
    }
}