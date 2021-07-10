class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 1; i < nums.length + 1; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        int max = 0;
        for(int i = 1; i < prefixSum.length; i++) {
            int num = prefixSum[i];
            if(num == k) {
                max = Math.max(i, max);
            }
            if(hm.containsKey(num)) {
                max = Math.max(i - hm.get(num), max);
            }
            else {
                hm.put(k + num, Math.min(hm.getOrDefault(k + num, prefixSum.length), i));
            }
        }
        return max;
    }
}