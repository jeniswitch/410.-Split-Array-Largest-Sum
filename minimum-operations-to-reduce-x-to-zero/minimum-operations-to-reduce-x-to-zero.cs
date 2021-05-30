public class Solution {
    public int MinOperations(int[] nums, int x) {
        int[] prefixSum = new int[nums.Length + 1];
        for(int i = 0; i < nums.Length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        if(prefixSum[nums.Length] == x) {
            return nums.Length;
        }
        int target = prefixSum[nums.Length] - x;
        int max = 0;
        int start = 0;
        for(int i = 0; i < nums.Length; i++) {
            while(start < nums.Length && prefixSum[i + 1] - prefixSum[start] > target) {
                start++;
            }
            if(prefixSum[i + 1] - prefixSum[start] == target) {
                max = Math.Max(i - start + 1, max);
            }
            //Console.WriteLine("index " + (i + 1) + " " + start);
            //Console.WriteLine(prefixSum[i + 1] + " " + prefixSum[start]);
        }
        return max == 0 ? -1 : nums.Length - max;
    }
}