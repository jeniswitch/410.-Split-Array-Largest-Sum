class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[nums2.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                res[stack.pop()] = nums2[i];
            }
            stack.push(i);
            hm.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = res[hm.get(nums1[i])];
        }
        return ans;
    }
}