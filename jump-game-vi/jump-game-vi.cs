public class Solution {
    public int MaxResult(int[] nums, int k) {
        List<int[]> dp = new List<int[]>();//index, max
        dp.Add(new int[]{0, nums[0]});
        int crr = nums[0];
        for(int i = 1; i < nums.Length; i++) {
            while(dp.Count > 0 && dp[0][0] < i - k) {
                dp.RemoveAt(0);
            }
            crr = nums[i] + dp[0][1];
            while(dp.Count > 0 && dp[dp.Count - 1][1] <= crr) {
                dp.RemoveAt(dp.Count - 1);
            }
            dp.Add(new int[]{i, crr});
        }
        return crr;
    }
}