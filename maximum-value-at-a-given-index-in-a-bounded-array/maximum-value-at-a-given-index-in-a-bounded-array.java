class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int l = 0, r = maxSum;
        while(l < r) {
            int mid = l + r + 1>> 1;
            if(check(n, index, mid) <= maxSum) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private long check(int n, int index, int maxSum){
        int a = Math.max(maxSum - index, 0);
        long sum = (long)(maxSum + a) * (maxSum - a + 1) / 2;
        int b = Math.max(maxSum - (n - 1 - index), 0);
        sum += (long)(maxSum + b) * (maxSum - b + 1) / 2;
        return sum - maxSum;
    }
}