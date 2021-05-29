public class Solution {
    public int MinSubarray(int[] nums, int p) {
        int remainder = 0;
        for(int i = 0; i < nums.Length; i++) {
            remainder = (remainder + nums[i]) % p;
        }
        if(remainder == 0) {
            return 0;
        }
        var prefixSumIndex = new Dictionary<int, int>();
        prefixSumIndex.Add(0, -1);
        int prefixSum = 0;
        int min = nums.Length;
        for(int i = 0; i < nums.Length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int crr = (prefixSum - remainder + p) % p;
            if(prefixSumIndex.ContainsKey(crr)) {
                min = Math.Min(min, i - prefixSumIndex[crr]);
            }
            prefixSumIndex[prefixSum] = i;
        }
        return min < nums.Length? min : -1;
    }
}