/*
        s = "abcacb", p = "ab", removable = [3,1,0]
        mid = 1; s='a*c*cb';
        mid = 2
*/
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] arr = s.toCharArray();
        int l = 0, r = removable.length;
        while(l <= r) {
            int mid = l + r >> 1;
            for(int i = 0; i < mid; i++) {
                arr[removable[i]] = '*';
            }
            if(check(arr, p)) {
                l = mid + 1;
            }
            else {
                for(int i = 0; i < mid; i++) {
                    arr[removable[i]] = s.charAt(removable[i]);
                }
                r = mid - 1;
            }
        }
        return r;
    }
    private boolean check(char[] arr, String p) {
        int p1 = 0, p2 = 0;
        while(p1 < arr.length && p2 < p.length()) {
            if(arr[p1] != '*' && arr[p1] == p.charAt(p2)) {
                p2++;
            }
            p1++;
        }
        return p2 == p.length();
    }
}