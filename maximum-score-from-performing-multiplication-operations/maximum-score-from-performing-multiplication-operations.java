class Solution {
    private int[] nums;
    private int[] mul;
    private Integer[][] memo;
    private int m, n;
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        mul = multipliers;
        m = mul.length;
        n = nums.length;
        memo = new Integer[m][m];
        return dp(0, 0);
    }
    private int dp(int l, int i) {
        int m = mul.length;
        int n = nums.length;
        if(i == m) return 0;
        if(memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l + 1, i + 1) + nums[l] * mul[i];
        int pickRight = dp(l, i + 1) + nums[n - (i - l) - 1] * mul[i];
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}