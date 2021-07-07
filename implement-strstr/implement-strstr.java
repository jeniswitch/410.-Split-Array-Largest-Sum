class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if(n == 0) {
            return 0;
        }
        if(m == 0) {
            return -1;
        }
        int[] ne = new int[n];
        ne[0] = -1;
        for(int i = 1, j = -1; i < n; i++) {
            while(j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) j = ne[j];
            if(needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            ne[i] = j;
        }
        for(int i = 0, j = -1; i < m; i++) {
            //System.out.println(j);
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) j = ne[j];
            if(haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if(j == n - 1) {
                return i- n + 1;
            }
        }
        return -1;
    }
}