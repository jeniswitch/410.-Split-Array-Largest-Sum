class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                max = i + 1;
            }
            if(hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            }
            else {
                hm.put(k + sum, Math.min(hm.getOrDefault(k + sum, nums.length), i));
            }
        }
        return max;
    }
}
