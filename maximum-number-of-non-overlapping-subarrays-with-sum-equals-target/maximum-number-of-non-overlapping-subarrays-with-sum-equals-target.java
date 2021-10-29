class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;
        map.put(0, 0);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }
        return res;
    }
}