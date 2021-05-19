public class Solution {
    public string MinRemoveToMakeValid(string s) {
        var stack = new Stack<int>();
        var set = new HashSet<int>();
        for(int i = 0; i < s.Length; i++) {
            char c = s[i];
            if(c == '(') {
                stack.Push(i);
            }
            else if(c == ')') {
                if(stack.Count == 0) {
                    set.Add(i);
                }
                else {
                    stack.Pop();
                }
            }
        }
        while(stack.Count > 0) {
            set.Add(stack.Pop());
        }
        if(set.Count == 0) {
            return s;
        }
        if(set.Count == s.Length) {
            return "";
        }
        var sb = new StringBuilder();
        for(int i = 0; i < s.Length; i++) {
            if(!set.Contains(i)) {
                sb.Append(s[i]);
            }
        }
        return sb.ToString();
    }
}