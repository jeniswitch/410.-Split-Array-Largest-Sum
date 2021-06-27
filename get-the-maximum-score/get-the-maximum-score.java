class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long a = 0, b = 0;
        long res = 0;
        final long mod = (long)1e9+7;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                a += nums1[i++];
            }
            else if(nums1[i] > nums2[j]) {
                b += nums2[j++];
            }
            else {
                res += Math.max(a, b) + nums1[i];
                a = 0;
                b = 0;
                i++;
                j++;
            }
        }
        while(i < nums1.length) {
            a += nums1[i++];
        }
        while(j < nums2.length) {
            b += nums2[j++];
        }
        res += Math.max(a, b);
        //return (int)res % (int)mod;
        return (int)(res % 1000000007);
    }
}