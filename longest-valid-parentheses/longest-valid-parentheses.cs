public class Solution {
    public int LongestValidParentheses(string s) {
        int open = 0;
        int close = 0;
        int max = 0;
        //from left to right
        for(int i = 0; i < s.Length; i++) {
            if(s[i] == '(') {
                open++;
            }
            else {
                close++;
            }
            if(open == close) {
                max = Math.Max(max, open * 2);
            }
            else if(close > open) {
                open = close = 0;
            }
        }
        open = close = 0;
        //from right to left
        for(int i = s.Length - 1; i >= 0; i--) {
            if(s[i] == '(') {
                open++;
            }
            else {
                close++;
            }
            if(open == close) {
                max = Math.Max(max, open * 2);
            }
            else if(open > close){
                open = close = 0;
            }
        }
        return max;
    }
}
