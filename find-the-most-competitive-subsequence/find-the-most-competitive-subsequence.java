class Solution {
    /*public int[] mostCompetitive(int[] nums, int k) {
        var stack = new Stack<Integer>();
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek() > nums[i] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if(stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }*/
    //use array
    public int[] mostCompetitive(int[] nums, int k) {
        int[] stack = new int[k];
        for(int i = 0, j = 0; i < nums.length; i++) {
            while(j > 0 && stack[j - 1] > nums[i] && nums.length - i + j > k) {
                j--;
            }
            if(j < k) {
                stack[j++] = nums[i];
            }
        }
        return stack;
    }
}
