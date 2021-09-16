class Solution {
    private int max;
    public int maxProduct(String s) {
        max = 0;
        dfs(s, 0, "", "");
        return max;
    }
    private void dfs(String s, int i, String s1, String s2) {
        if(i == s.length()) {
            if(isPal(s1) && isPal(s2)) {
                max = Math.max(max, s1.length() * s2.length());
            }
            return;
        }
        
        dfs(s, i + 1, s1, s2);
        dfs(s, i + 1, s1 + s.charAt(i), s2);
        dfs(s, i + 1, s1, s2 + s.charAt(i));
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i < s.length() && j >= 0 && i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}