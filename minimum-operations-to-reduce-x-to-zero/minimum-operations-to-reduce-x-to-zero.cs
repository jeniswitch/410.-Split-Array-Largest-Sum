public class Solution {
    public int MinOperations(int[] nums, int x) {
        int total = 0;
        for(int i = 0; i < nums.Length; i++) {
            total += nums[i];
        }
        int target = total - x;
        int max = -1;
        int start = 0;
        int crrSum = 0;
        for(int i = 0; i < nums.Length; i++) {
            crrSum += nums[i];
            while(start <= i && crrSum > target) {
                crrSum -= nums[start++];
            }
            if(crrSum == target) {
                max = Math.Max(i - start + 1, max);
            }
        }
        return max != -1? nums.Length - max : max;
    }
}
