class Solution {
    private double[] p;
    public Solution(int[] w) {
        p = new double[w.length];
        double sum = 0;
        for(int i : w) {
            sum += i;
        }
        for(int i = 0; i < w.length; i++) {
            w[i] += i == 0 ? 0 : w[i - 1];
            p[i] = w[i] / sum;
        }
    }
    
    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(p, Math.random())) - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */