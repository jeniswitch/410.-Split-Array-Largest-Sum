class NumArray {
    private int[] _prefixSum;
    public NumArray(int[] nums) {
        _prefixSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            _prefixSum[i + 1] = nums[i] + _prefixSum[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return _prefixSum[right + 1] - _prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */