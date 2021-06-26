class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int res = 0;
        for(long num : nums1) {
            res += helper(num * num, nums2);
        }
        for(long num : nums2) {
            res += helper(num * num, nums1);
        }
        return res;
    }
    private int helper(long target, int[] nums) {
        HashMap<Long, Integer> hm = new HashMap<>();
        int count = 0;
        for(long num : nums) {
            if(target % num == 0) {
                count += hm.getOrDefault(target / num, 0);
            }
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}