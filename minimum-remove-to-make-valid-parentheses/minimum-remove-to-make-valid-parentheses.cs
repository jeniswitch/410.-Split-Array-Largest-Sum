public class Solution {
    public string MinRemoveToMakeValid(string s) {
        string res = RemoveInvalidChar(s, '(', ')');
        res = RemoveInvalidChar(new string(res.Reverse().ToArray()), ')', '(');
        return new string(res.Reverse().ToArray());
    }
    private string RemoveInvalidChar(string s, char open, char close) {
        var sb = new StringBuilder();
        int balance = 0;
        foreach(char c in s) {
            if(c == open) {
                balance++;
            }
            else if(c == close) {
                if(balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.Append(c);
        }
        return sb.ToString();
    }
}
