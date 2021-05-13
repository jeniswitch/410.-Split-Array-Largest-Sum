
public class Solution {
    public IList<string> MaxNumOfSubstrings(string s) {
        int[] low = new int[26];
        int[] high = new int[26];
        Array.Fill(low, s.Length);
        for(int i = 0; i < s.Length; i++) {
            int index = s[i] - 'a';
            low[index] = Math.Min(low[index], i);
            high[index] = Math.Max(high[index], i);
        }
        var stack = new Stack<int[]>();
        for(int i = 0; i < s.Length; i++) {
            int index = s[i] - 'a';
            int l = low[index], r = high[index];
             Console.WriteLine("i " + i  + " l " + l);
            if(i != l) {
                continue;
            }
           
            int end = DoubleCheckHigh(s, l, r, low, high);
            Console.WriteLine("i " + i  + " end " + end);
            if(end < 0) {
                continue;
            }
            while(stack.Count > 0 && l >= stack.Peek()[0] 
                  && end <= stack.Peek()[1]) {
                Console.WriteLine("pop " + stack.Peek()[0]  + " " + stack.Peek()[1]);
                stack.Pop();
            }
            Console.WriteLine("push " + l  + " " + end);
            stack.Push(new int[]{l, end});
        }
        IList<string> lst = new List<string>();
        while(stack.Count > 0) {
            int[] range = stack.Pop();
            lst.Add(s.Substring(range[0], range[1] - range[0] + 1));
        }
        return lst;
    }
    private int DoubleCheckHigh(string s, int l, int r, int[] low, int[] high) {
        for(int i = l + 1; i < r; i++) {
            if(low[s[i] - 'a'] < l) {
                return -1;
            }
            r = Math.Max(high[s[i] - 'a'], r);
        }
        return r;
    }
}