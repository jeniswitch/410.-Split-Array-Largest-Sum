public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.Length + 1];
        for(int i = 1; i < sums.Length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }
    
    public int SumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.SumRange(left,right);
 */