/*
343 + 43 * 445
*/
class Solution {
    private HashMap<Character, Integer> map;
    private Stack<Integer> num;
    private Stack<Character> op;
    public int calculate(String s) {
        op = new Stack<>();
        num = new Stack<>();
        map = new HashMap<>(){
            {put('+', 0); 
             put('-', 0);
             put('*', 1);
             put('/', 1);}};
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            else if(isDigit(c)) {
                int j = i, x = 0;
                while(j < s.length() && isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                    //System.out.println("x " + x);
                    j++;
                }
                num.push(x);
                i = j - 1;
                //System.out.println(num);
            }
            else {
                while(!op.isEmpty() && map.get(op.peek()) >= map.get(c)) {
                    eval();
                }
                op.push(c);
            }
        }
        while(!op.isEmpty()) {
            eval();
        }
        return num.pop();
    }
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    private void eval() {
        int a = num.pop();
        int b = num.pop();
        char c = op.pop();
        int res = 0;
        switch(c) {
            case '+' : res = b + a;
                break;
            case '-' : res = b - a;
                break;
            case '*' : res = b * a;
                break;
            case '/' : res = b / a;
                break;
        }
        num.push(res);
    }
}