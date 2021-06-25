class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(6 * nums1.length < nums2.length || nums1.length > nums2.length * 6) {
            return -1;
        }
        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();
        if(sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1;
        int count = 0;
        while(sum1 < sum2) {
            if(j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++];
            }
            else {
                sum2 -= nums2[j--] - 1;
            }
            count++;
        }
        return count;
    }
}