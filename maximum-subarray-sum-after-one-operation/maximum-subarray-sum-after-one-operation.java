class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int maxNoOp = nums[0];
        int maxOp = nums[0] * nums[0];
        int max = Math.max(maxNoOp, maxOp);
        for(int i = 1; i < nums.length; i++) {
            int temp = nums[i] * nums[i];
            maxOp = Math.max(Math.max(maxNoOp + temp, maxOp + nums[i]), temp);
            maxNoOp = Math.max(nums[i], maxNoOp + nums[i]);
            max = Math.max(max, Math.max(maxOp, maxNoOp));
        }
        return max;
    }
}