class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] q = new int[n];
        int hh = 0, tt = -1;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }
            while(hh <= tt && nums[q[tt]] <= nums[i]) {
                tt--;
            }
            q[++tt] = i;
            if(i + 1 >= k) {
                res[idx++] = nums[q[hh]];
            }
        }
        return res;
    }
}