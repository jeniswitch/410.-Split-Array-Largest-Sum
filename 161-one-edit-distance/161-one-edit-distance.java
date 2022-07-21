class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        //if(Math.abs(ls - lt) > 1) return false;
        boolean sameLength = ls == lt;
        if(ls > lt) {
            return isOneEditDistance(t, s);
        }
        for(int i = 0; i < ls; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(sameLength) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else {
                    System.out.println(s.substring(i) + " " + t.substring(i + 1));
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return ls + 1 == lt || lt + 1 == ls;
    }
}