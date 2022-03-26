class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        if(n == -1) {
            return 1 / x;
        }
        double res = myPow(x, n / 2);
        res *= res;
        if(n % 2 != 0) {
            res *= n > 0 ? x : (1 / x);
        }
        return res;
    }
}