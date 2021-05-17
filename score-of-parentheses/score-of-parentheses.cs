public class Solution {
    public int ScoreOfParentheses(string s) {
        int bal = 0;
        int count = 0;
        for(int i = 0; i < s.Length; i++) {
            if(s[i] == '(') {
                bal++;
            }
            else {
                bal--;
                if(s[i - 1] == '(') {
                    count += 1 << bal;
                }
            }
        }
        return count;
    }
}
