class Solution {
    /*public int validSubarrays(int[] nums) {
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
    }*/
    //use array
    public int validSubarrays(int[] nums) {
        int[] stack = new int[nums.length];
        int count = nums.length;
        stack[0] = nums[0];
        for(int i = 1, j = 1; i < nums.length; i++) {
            while(j > 0 && stack[j - 1] > nums[i]) {
                j--;
            }
            count += j;
            stack[j++] = nums[i];
        }
        return count;
    }
}
