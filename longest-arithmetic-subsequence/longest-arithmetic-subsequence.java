class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 2;
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        for(int j = 0; j < nums.length; j++) {
            map[j] = new HashMap<>();
            for(int i = 0; i < j; i++) {
                int d = nums[j] - nums[i];
                map[j].put(d, map[i].getOrDefault(d, 1) + 1);
                max = Math.max(max, map[j].get(d));
            }
        }
        return max;
    }
}