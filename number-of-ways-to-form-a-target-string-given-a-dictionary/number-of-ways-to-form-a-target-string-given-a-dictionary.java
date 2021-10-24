class Solution {
    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        Integer[][] memo = new Integer[m][n];
        int[][] count = new int[26][m];
        for(String w : words) {
            for(int i = 0; i < w.length(); i++) {
                count[w.charAt(i) - 'a'][i]++;
            }
        }
        return dfs(words, target, 0, 0, memo, count);
    }
    private int dfs(String[] words, String target, int p, int t, Integer[][] memo, int[][] count) {
        if(t == target.length()) return 1;
        if(p == words[0].length()) return 0;
        if(memo[p][t] != null) return memo[p][t];
        char c = target.charAt(t);
        long res = dfs(words, target, p + 1, t, memo, count);
        if(count[c - 'a'][p] > 0) {
            res += (long)dfs(words, target, p + 1, t + 1, memo, count) * count[c - 'a'][p];
            res %= (long)(1e9) + 7;
        }
        return memo[p][t] = (int)res;                                                 
    }
}