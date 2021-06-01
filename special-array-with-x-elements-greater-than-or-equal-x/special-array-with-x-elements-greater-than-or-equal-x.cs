public class Solution {
    public int SpecialArray(int[] nums) {
        Array.Sort(nums);
        int start = 0;
        int end = nums.Length - 1;
        int mid = 0;
        if(nums.Length == 1) {
            return nums[0] >= 1 ? 1 : -1;
        }
        while(start < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == nums.Length - mid) {
                if(mid == 0) {
                    return nums[mid];
                }
                else if(nums[mid - 1] == nums.Length - mid) {
                    return -1;
                }
                return nums[mid];
            }
            else if(nums[mid]  > nums.Length - mid) {
                if(mid == 0) {
                    return nums.Length - mid;
                }
                else if(nums[mid - 1] == nums.Length - mid) {
                    return -1;
                }
                else if(nums[mid - 1] < nums.Length - mid) {
                    return nums.Length - mid;
                }
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}