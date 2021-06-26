class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }
    private int helper(int[] nums1, int[] nums2) {
        int res = 0;
        for(long n1 : nums1) {
            HashMap<Long, Integer> hm = new HashMap<>();
            long target = n1 * n1;
            for(long n2 : nums2) {
                if(target % n2 == 0) {
                    res += hm.getOrDefault(target / n2, 0);
                }
                hm.put(n2, hm.getOrDefault(n2, 0) + 1);
            }
        }
        return res;
    }
}
