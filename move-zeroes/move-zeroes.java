class Solution {
    public void moveZeroes(int[] nums) {
        int len = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int j = i + len;
                while(j < nums.length && nums[j] == 0) {
                    j++;
                }
                if(j < nums.length) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    len = j - i;
                }
            }
        }
    }
}