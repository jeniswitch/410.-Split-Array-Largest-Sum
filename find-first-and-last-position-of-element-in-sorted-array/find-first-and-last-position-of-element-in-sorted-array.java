/*  target = 8
    5,  7,  7,  8,  8,  10      first: <= target? r = mid
                l        r
    l                    r      >= target l = mid;
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        //find start
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + r>> 1;
            if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if(nums[l] != target) {
            return new int[]{-1, -1};
        }
        res[0] = l;
        
        //find end
        r = nums.length - 1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        
        res[1] = l;
        return res;
    }
}