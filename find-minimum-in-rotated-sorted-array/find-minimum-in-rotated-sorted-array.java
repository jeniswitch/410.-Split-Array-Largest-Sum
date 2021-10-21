class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        int l = 0, r = n - 1;
        while(l < r) {
            if(nums[l] < nums[r]) return nums[l];
            if(l + 1 == r) return Math.min(nums[l], nums[r]);
            int mid = l + (r - l) / 2;
            if(nums[l] < nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}