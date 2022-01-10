class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findStarting(nums, target), findEnding(nums, target)};
    }
    private int findStarting(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                r = mid - 1;
                if(nums[mid] == target) {
                    res = mid;
                }
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
        }
        return res;
    }
    private int findEnding(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            }
            else if(nums[mid] <= target) {
                l = mid + 1;
                if(nums[mid] == target) {
                    res = mid;
                }
            }
        }
        return res;
    }
}