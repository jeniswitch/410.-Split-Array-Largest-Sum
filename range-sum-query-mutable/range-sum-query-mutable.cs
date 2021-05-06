public class NumArray {
    private int[] bit;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        bit = new int[nums.Length + 1];
        for(int i = 0; i < nums.Length; i++) {
            UpdateBIT(i + 1, nums[i]);
        }
    }
    private int GetSumBIT(int index) {
        int sum = 0;
        while(index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }
    private void UpdateBIT(int index, int val) {
        while(index < bit.Length) {
            bit[index] += val;
            index += index & -index;
        }
    }
    public void Update(int index, int val) {
        UpdateBIT(index + 1, val - nums[index]);
        nums[index] = val;
    }
    
    public int SumRange(int left, int right) {
        return GetSumBIT(right + 1) - GetSumBIT(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.Update(index,val);
 * int param_2 = obj.SumRange(left,right);
 */