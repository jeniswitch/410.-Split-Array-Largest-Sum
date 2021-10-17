class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] memo = new int[n];
        int[] next = new int[n];
        Arrays.fill(memo, -1);
        Arrays.fill(next, -1);
        dfs(coins, maxJump, memo, next, 0);
        List<Integer> path = new ArrayList<>();
        path.add(1);
        for(int i = 0; i < n && next[i] >= 0; i = next[i]) {
            path.add(next[i] + 1);
        }
        if(path.contains(n)) return path;
        return new ArrayList<>();
    }
    private int dfs(int[] coins, int maxJump, int[] memo, int[] next, int p) {
        if(memo[p] != -1) return memo[p];
        if(p == coins.length - 1) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 1; i <= maxJump; i++) {
            if(p + i < coins.length && coins[p + i] != -1) {
                int temp = dfs(coins, maxJump, memo, next, p + i);
                if(temp < minCost) {
                    minCost = temp;
                    minIdx = p + i;
                }
            }
        }
        next[p] = minIdx;
        memo[p] = coins[p] + minCost;
        return memo[p];
    }
}