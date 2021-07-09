class Solution {
    private int[] sum;
    private Random rand;
    public Solution(int[] w) {
        rand = new Random();
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }
    
    public int pickIndex() {
        int target = rand.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length - 1;
        while(left < right) {
            int mid = left + right >> 1;
            if(sum[mid] == target) {
                return mid;
            }
            else if(sum[mid] > target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */