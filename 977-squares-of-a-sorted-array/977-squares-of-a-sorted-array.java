class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            int sq = 0;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                sq = nums[right--];   
            }
            else {
                sq = nums[left++];
            }
            res[i] = sq * sq;
        }
        return res;
    }
}