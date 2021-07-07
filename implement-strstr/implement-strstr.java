class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() == 0) {
            return -1;
        }
        int i = 0, j = 0;
        while(i < haystack.length()) {
            j = 0;
            while(j < needle.length()) {
                if(i + j == haystack.length()) {
                    return -1;
                }
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if(j == needle.length() - 1) {
                    return i;
                }
                j++;
            }
            i++;
        }
        return -1;
    }
}