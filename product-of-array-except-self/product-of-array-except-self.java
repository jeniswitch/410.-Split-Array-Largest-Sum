/*
//O(N) time, O(N) space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
            right[nums.length - i - 1] = i == 0 ? 1 : right[nums.length - i] * nums[nums.length - i];
        }
        
        for(int i = 0; i < nums.length; i++) {
            left[i] *= right[i];
        }
        return left;
    }
}*/
//O(N) time, O(1) space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int runningPrefix = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = runningPrefix;
            runningPrefix *= nums[i];
        }
        int runningSuffix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= runningSuffix;
            runningSuffix *= nums[i];
        }
        return res;
    }
}
