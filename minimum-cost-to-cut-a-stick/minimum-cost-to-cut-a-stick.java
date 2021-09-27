class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> c = new ArrayList<Integer>();
        for(int cut : cuts) {
            c.add(cut);
        }
        c.add(0);
        c.add(n);
        Collections.sort(c);
        int m = c.size();
        int[][] dp = new int[m][m];
        for(int d = 2; d < m; d++) {
            for(int i = 0; i < m - d; i++) {
                dp[i][i + d] = Integer.MAX_VALUE;
                for(int k = i + 1; k < i + d; k++) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][k] + dp[k][i + d] + c.get(i + d) - c.get(i));
                }
            }
        }
        return dp[0][m - 1];
    }
}