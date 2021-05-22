public class Solution {
    public class Tuple{
        public string s;
        public int start;
        public char removed;
        public Tuple(string s, int start, char removed) {
            this.s = s;
            this.start = start;
            this.removed = removed;
        }
    }
    public IList<string> RemoveInvalidParentheses(string s) {
        IList<string> lst = new List<string>();
        if(IsValid(s)) {
            lst.Add(s);
            return lst;
        }
        var q = new Queue<Tuple>();
        q.Enqueue(new Tuple(s, 0, ')'));
        while(q.Count > 0) {
            Tuple crr = q.Dequeue();
            for(int i = crr.start; i < crr.s.Length; i++) {
                char c = crr.s[i];
                if(c != '(' && c != ')' 
                   || i != crr.start && crr.s[i - 1] == c
                  || crr.removed == '(' && c == ')') {
                    continue;
                }
                string str = crr.s.Substring(0, i) + crr.s.Substring(i + 1);
                if(IsValid(str)) {
                    lst.Add(str);
                }
                else if(lst.Count == 0) {
                    q.Enqueue(new Tuple(str, i, c));
                }
            }
        }
        return lst;
    }
    private bool IsValid(string s) {
        int bal = 0;
        foreach(char c in s) {
            if(c == '(') {
                bal++;
            }
            else if(c == ')') {
                if(bal == 0) {
                    return false;
                }
                bal--;
            }
        }
        return bal == 0;
    }
}