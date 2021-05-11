public class Solution {
    public int FindUnsortedSubarray(int[] nums) {
        int min = nums.Length;
        int max = 0;
        var stack = new Stack<int>();
        for(int i = 0; i < nums.Length; i++) {
            while(stack.Count > 0 && nums[i] < nums[stack.Peek()]) {
                min = Math.Min(min, stack.Pop());
            }
            stack.Push(i);
        }
        stack.Clear();
        for(int i = nums.Length - 1; i >= 0; i--) {
            while(stack.Count > 0 && nums[stack.Peek()] < nums[i]) {
                max = Math.Max(max, stack.Pop());
            }
            stack.Push(i);
        }
        return max > min ? max - min + 1 : 0;
    }
}
