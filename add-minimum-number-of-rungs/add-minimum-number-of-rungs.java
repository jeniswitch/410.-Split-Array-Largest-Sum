class Solution {
    public int addRungs(int[] rungs, int dist) {
        int pre = 0, res = 0;
        for(int num : rungs) {
            res += (num - pre - 1) / dist;
            pre = num;
        }
        return res;
    }
}