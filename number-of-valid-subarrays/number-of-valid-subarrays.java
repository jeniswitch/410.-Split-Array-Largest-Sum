class Solution {
    public int validSubarrays(int[] nums) {
        var stack = new Stack<Integer>();
        int count = nums.length;
        stack.push(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            count += stack.size();
            stack.push(nums[i]);
        }
        return count;
    }
}