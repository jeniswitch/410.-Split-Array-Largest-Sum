class Solution {
    public double myPow(double x, int n) {
        int N = n;
        if(N < 0) {
            N = -N;
            x = 1 / x;
        }
        return helper(x, N);
    }
    private double helper(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double ans = helper(x, n / 2);
        if(n % 2 == 0) return ans * ans;
        else return ans * ans * x;
    }
}