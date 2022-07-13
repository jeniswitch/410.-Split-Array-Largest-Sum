class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int pre0 = 0;
        int pre1 = 1;
        int crr = 0;
        for(int i = 2; i <= n; i++) {
            crr = pre0 + pre1;
            pre0 = pre1;
            pre1 = crr;
        }
        return crr;
    }
}