class Solution {
    private Stack<Integer> num;
    private Stack<Character> op;
    public int calculate(String s) {
        s = s.replace(" ", "");
        //System.out.println(s);
        num = new Stack<>();
        op = new Stack<>();
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            num.push(0);
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int j = i, x = 0;
                while(j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                //System.out.println("x j " + x + " " + j);
                num.push(x);
                i = j - 1;
            }
            else if(c == '(') {
                op.push(c);
            }
            else if(c == ')') {
                while(!op.isEmpty() && op.peek() != '(') {
                    eval();
                }
                op.pop();
            }
            else {
                if(!op.isEmpty() && op.peek() != '(') {
                    eval();
                    if(i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if(next == '+') {
                            i++;
                            op.push(c);
                        }
                        else if(next == '-') {
                            i++;
                            op.push(c == '-' ? '+' : '-');
                        }
                        else {
                            op.push(c);
                        }
                    }
                }
                else {
                    if(i > 0 && s.charAt(i - 1) == '(') {
                        continue;
                    }
                    else
                    op.push(c);
                }
            }
        }
        while(!op.isEmpty()) {
            eval();
        }
        return num.pop();
    }
    private void eval() {
        //System.out.println(num);
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int x = 0;
        if(c == '+') {
            x = a + b;
        }
        else {
            x = a - b;
        }
        num.push(x);
    }
}