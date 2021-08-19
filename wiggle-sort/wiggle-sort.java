class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}