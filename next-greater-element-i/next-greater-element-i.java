class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]);
            int next = -1;
            for(int j = idx + 1; j < nums2.length; j++) {
                if(nums2[j] > nums1[i]) {
                    next = nums2[j];
                    break;
                }
            }
            res[i] = next;
         }
        return res;
    }
}