public class Solution {
    public int LongestValidParentheses(string s) {
        var stack = new Stack<int>();
        stack.Push(-1);
        int max = 0;
        for(int i = 0; i < s.Length; i++) {
            if(s[i] == '(') {
                stack.Push(i);
            }
            else {
                stack.Pop();
                if(stack.Count == 0) {
                    stack.Push(i);
                }
                else {
                    max = Math.Max(max, i - stack.Peek());
                }
            }
        }
        return max;
    }
}