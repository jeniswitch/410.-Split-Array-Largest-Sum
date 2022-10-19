class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, minMax = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minMax = (long)Math.max((double)minMax, Math.ceil((double)sum / (i + 1)));
        }
        return (int)minMax;
    }
}