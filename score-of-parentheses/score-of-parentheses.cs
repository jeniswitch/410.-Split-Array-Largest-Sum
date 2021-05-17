public class Solution {
    public int ScoreOfParentheses(string s) {
        var stackb = new Stack<int>();
        var stackRange = new Stack<int[]>();
        for(int i = 0; i < s.Length; i++) {
            if(stackb.Count > 0 && s[stackb.Peek()] == '(' && s[i] == ')') {
                int start = stackb.Pop();
                if(start + 1 == i) {
                    stackRange.Push(new int[]{start, i, 1});
                }
                else {
                    int countInside = 0;
                     while(stackRange.Count > 0 && stackRange.Peek()[0] >= start && stackRange.Peek()[1] <= i) {
                        countInside += stackRange.Pop()[2];
                     } 
                     stackRange.Push(new int[]{start, i, 2 * countInside});
                }
            }
            else {
                stackb.Push(i);
            }
        }
        int count = 0;
        while(stackRange.Count > 0) {
            count += stackRange.Pop()[2];
        }
        return count;
    }
}