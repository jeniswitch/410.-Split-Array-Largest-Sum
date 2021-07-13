class Solution {
    public int calculate(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);

        Stack<Character> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int d = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                d = c - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    d = d * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num.push(d);
            }
            else if(c == '*' || c == '/' || c == '+' || c == '-') {
                while(!stack.isEmpty() && checkPre(stack.peek()) && map.get(stack.peek()) >= map.get(c)) {
                    eval(stack, num);
                }
                stack.push(c);
                
            }
            else if(c == '(') {
                stack.push(c);
            }
            else {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    eval(stack, num);
                }
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            eval(stack, num);
        }
        return num.pop();
    }
    private void eval(Stack<Character> stack, Stack<Integer> num) {
        int b = num.pop();
        char operator = stack.pop();
        int a = num.pop();
        int res = 0;
        if(operator == '+') {
            res += a + b;
        }
        else if(operator == '-') {
            res += a - b;
        }
        else if(operator == '*') {
            res += a * b;
        }
        else if(operator == '/') {
            res += a / b;
        }
        num.push(res);
        //System.out.println(res);
    }
    private boolean checkPre(char pre) {
        if(pre == '(' || pre == ')') return false;
        return true;
    }
}