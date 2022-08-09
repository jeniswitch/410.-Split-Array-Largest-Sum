class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(Math.abs(lens - lent) > 1) return false;
        if(lens <= lent) {
            return helper(s, t);
        }
        else {
            return helper(t, s);
        }
    }
    private boolean helper(String s, String t) {
        int i = 0;
        boolean sameLen = s.length() == t.length();
        while(i < s.length()) {
            if(s.charAt(i) != t.charAt(i)) {
                if(sameLen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
            i++;
        }
        return !sameLen; 
    }

}