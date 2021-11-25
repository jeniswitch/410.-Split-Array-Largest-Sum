class Solution {
    private int[] prefixSum;
    private Random rd;
    public Solution(int[] w) {
        rd = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int idx = rd.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int i = Arrays.binarySearch(prefixSum, idx);
        return i >= 0 ? i : -i - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */