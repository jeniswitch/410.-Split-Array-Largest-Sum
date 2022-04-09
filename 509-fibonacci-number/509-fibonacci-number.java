class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int pre1 = 0;
        int pre2 = 1;
        for(int i = 2; i <= n; i++) {
            int crr = pre1 + pre2;
            pre1 = pre2;
            pre2 = crr;
        }
        return pre2;
    }

}