class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int res = 0;
        int sign = 1;
        int num = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                num = 0;
            }
            else if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if(c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            }
            else if(c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            }
            else if(c == ')') {
                res += sign * num;
                num = 0;
                res = res * stack.pop() + stack.pop();
            }
        }
        if(num != 0) res += sign * num;
        return res;
    }
}