class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        if(Math.abs(ls - lt) > 1) return false;
        if(ls < lt) {
            return helper(s, t);
        }
        else {
            return helper(t, s);
        }
    }
    private boolean helper(String s, String t) {
        int i = 0, j = 0;
        boolean hasDifference = false;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) {
                if(s.length() == t.length()) {
                    if(hasDifference) return false;
                    hasDifference = true;
                    i++;
                }
                else if(i != j) {
                    return false;
                }
                j++;
            }
            else {
                i++;
                j++;
            }
        }
        return s.length() == t.length() ? hasDifference : true;
    }
}