class Solution {
    public int findBestValue(int[] arr, int target) {
        int s = 0, l = 1, r = 0;
        for(int num : arr) {
            s += num;
            r = Math.max(r, num);
        }
        if(s <= target) {
            return r;
        }
        int s1 = 0, s2 = 0;
        while(l < r) {
            int mid = l + r >> 1;
            s = 0;
            for(int num : arr) {
                s += Math.min(num, mid); 
            }
            if(s >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        for(int num : arr) {
            s1 += Math.min(num, l);
            s2 += Math.min(num, l - 1);
        }
        return Math.abs(s2 - target) <= Math.abs(s1 - target)? l - 1 : l;
    }
}