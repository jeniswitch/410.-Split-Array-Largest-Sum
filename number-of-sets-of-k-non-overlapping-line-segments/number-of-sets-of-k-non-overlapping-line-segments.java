class Solution {
    private Integer[][][] memo;
    private int n;
    public int numberOfSets(int n, int k) {
        memo = new Integer[n + 1][k + 1][2];
        this.n = n;
        return dfs(0, k, 1);
    }
    private int dfs(int p, int k, int isStart) {
        if(k == 0) return 1;
        if(p == n) return 0;
        if(memo[p][k][isStart] != null) return memo[p][k][isStart];
        int res = dfs(p + 1, k, isStart);
        if(isStart == 1) {
            res += dfs(p + 1, k, 0);
        }
        else {
            res += dfs(p, k - 1, 1);
        }
        return memo[p][k][isStart] = res % ((int)1e9 + 7);
    }
}