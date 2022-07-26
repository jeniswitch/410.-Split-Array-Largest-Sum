class Solution {
    public int compress(char[] chars) {
        int currIdx = 0, idx = 0;
        while(idx < chars.length) {
            char c = chars[idx++];
            int count = 1;
            while(idx < chars.length && chars[idx] == c) {
                idx++;
                count++;
            }
            chars[currIdx++] = c;
            if(count > 1) {
                String str = String.valueOf(count);
                for(char cc : str.toCharArray()) {
                    chars[currIdx++] = cc;
                }
            }
        }
        return currIdx;
    }
}