class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        String dig = "";
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                dig += c;
            }
            else if(c == ']') {
                String repeatStr = "";
                while(!str.isEmpty() && !str.peek().equals("[")) {
                    repeatStr = str.pop() + repeatStr;
                }
                str.pop();
                int repeatTime = num.pop();
                String temp = "";
                for(int i = 0; i < repeatTime; i++) {
                    temp += repeatStr;
                }
                str.push(temp);
            }
            else {
                if(dig.length() > 0) {
                    num.push(Integer.parseInt(dig));
                    dig = "";
                }
                str.push(Character.toString(c));
            }
        }
        String res = "";
        while(!str.isEmpty()) {
            res = str.pop() + res;
        }
        return res;
    }
}