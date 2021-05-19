public class Solution {
    public IList<int> DiffWaysToCompute(string expression) {
        IList<int> res = new List<int>();
        
        for(int i = 0; i < expression.Length; i++) {
            char c = expression[i];
            if(c == '+' || c == '*' || c == '-') {
                IList<int> left = DiffWaysToCompute(expression.Substring(0, i));
                IList<int> right = DiffWaysToCompute(expression.Substring(i + 1));
                foreach(int l in left) {
                    foreach(int r in right) {
                        switch(c) {
                            case '+' :
                                res.Add(l + r);
                                break;
                            case '-' :
                                res.Add(l - r);
                                break;
                            default:
                                res.Add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(res.Count == 0) {
            res.Add(Int32.Parse(expression));
        }
        return res;
    }
}