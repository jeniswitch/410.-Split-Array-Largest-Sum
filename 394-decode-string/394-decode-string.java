class Solution {
    public String decodeString(String s) {
        Stack<String> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        String num = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num += String.valueOf(s.charAt(i));
            }
            else {
                if(num.length() > 0) {
                    stackNum.push(num);
                }
                num = "";
                String str = "";
                if(s.charAt(i) == ']') {
                    while(!stackStr.isEmpty() && !stackStr.peek().equals("[")) {
                        str = stackStr.pop() + str;
                    }
                    stackStr.pop();
                    String newStr = "";
                    int inum = Integer.parseInt(stackNum.pop());
                    for(int j = 0; j < inum; j++) {
                        newStr += str;
                    }
                    stackStr.push(newStr);
                }
                else {
                    stackStr.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        String res = "";
        while(!stackStr.isEmpty()) {
            res = stackStr.pop() + res;
        }
        return res;
    }
}