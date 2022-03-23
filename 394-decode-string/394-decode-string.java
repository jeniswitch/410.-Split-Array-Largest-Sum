class Solution {
    private int idx = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(idx < s.length()) {
            char c = s.charAt(idx++);
            
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if(c == '[') {
                String sub = decodeString(s);
                for(int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            }
            else if(c == ']') {
                break;
            }
            else {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}