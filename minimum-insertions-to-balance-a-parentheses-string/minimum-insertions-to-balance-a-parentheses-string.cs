public class Solution {
    public int MinInsertions(string s) {
        int leftCount = 0;
        int count = 0;
        string str = s.Replace("))", "]");
        foreach(char c in str) {
            if(c == '(') {
                leftCount++;
            }
            else {
                if((c == ')' || c == ']') && leftCount > 0) {
                    leftCount--;
                    count += c == ')'? 1 : 0;
                }
                else {
                    count += c == ')' ? 2 : 1;
                }
            }
        }
        return count + 2 * leftCount;
    }
}