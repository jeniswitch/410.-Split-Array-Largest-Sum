class Solution {
    public int compress(char[] chars) {
        int count = 0;
        int idx = 0;
        for(int i = 0; i < chars.length; i++) {
            count++;
            if(i == chars.length - 1 || chars[i] != chars[i + 1])
            {
                chars[idx++] = chars[i]; 
                if(count > 1) {
                    String str = String.valueOf(count);
                    for(char c : str.toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                count = 0;
            }
        }
        return idx;
    }
}