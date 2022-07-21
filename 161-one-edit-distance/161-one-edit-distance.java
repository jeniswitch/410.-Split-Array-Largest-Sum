class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        if(ls == lt) {
            return replaceOne(s, t);
        }
        if(Math.abs(ls - lt) != 1) return false;
        if(ls < lt) {
            return insertDeleteOne(s, t);
        }
        else {
            return insertDeleteOne(t, s);
        }
    }
    private boolean replaceOne(String s, String t) {
        boolean hasDifference = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(hasDifference) return false;
                hasDifference = true;
            }
        }
        return hasDifference;
    }
    private boolean insertDeleteOne(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) {
                if(i != j) {
                    return false;
                }
                j++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }
}