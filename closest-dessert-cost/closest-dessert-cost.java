class Solution {
    private int res;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Integer.MAX_VALUE;
        for(int i : baseCosts) {
            dfs(i, 0, toppingCosts, target);
            if(res == target) {
                return res;
            }
        }
        return res;
    }
    private void dfs(int crr, int i, int[] toppingCosts, int target) {
        check(crr, target);
        if(i == toppingCosts.length || crr > target) return;
        dfs(crr, i + 1, toppingCosts, target);
        dfs(crr + toppingCosts[i], i + 1, toppingCosts, target);
        dfs(crr + toppingCosts[i] * 2, i + 1, toppingCosts, target);
    }
    private void check(int crr, int target) {
        int diffc = Math.abs(crr - target);
        int diffr = Math.abs(res - target);
        if(diffc == diffr) {
            res = Math.min(crr, res);
        }
        else {
            res = diffc < diffr ? crr : res;
        }
    }
}