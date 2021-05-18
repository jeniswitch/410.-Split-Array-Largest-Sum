public class Solution {
    public bool CheckValidString(string s) {
        var pStart = new Stack<int>();
        var star = new Stack<int>();
        for(int i = 0; i < s.Length; i++) {
            if(s[i] == '(') {
                pStart.Push(i);
            }
            else if(s[i] == '*') {
                star.Push(i);
            }
            else {
                if(pStart.Count > 0) {
                    pStart.Pop();
                }
                else if(star.Count > 0) {
                    star.Pop();
                }
                else {
                    return false;
                }
            }
        }
        while(pStart.Count > 0) {
            if(star.Count == 0 || star.Pop() < pStart.Pop()) {
                return false;
            }
        }
        return true;
    }
}