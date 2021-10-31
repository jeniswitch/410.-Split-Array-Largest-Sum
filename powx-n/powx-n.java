class Solution {
    public double myPow(double x, int n) {
        int N = n;
        if(n < 0) {
            N = -n;
            x = 1 / x;
        }
        return fastPow(x, N);
    }
    private double fastPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double res = fastPow(x, n / 2);
        if(n % 2 == 0) {
            return res * res;
        }
        else {
            return res * res * x;
        }
    }
}