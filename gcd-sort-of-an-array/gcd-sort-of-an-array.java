class Solution {
    private int[] p;
    public boolean gcdSort(int[] nums) {
        p = new int[100001];
        for(int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for(int n : nums) {
            int y = n;
            for(int k = 2; p[y] == y && k * k <= y; k++) {
                if(y % k == 0) {
                    union(n, k);
                    while(y % k == 0) y /= k;
                }
            }
            if(y != 1) union(n, y);
        }
        int[] st = nums.clone();
        Arrays.sort(st);
        for(int i = 0; i < nums.length; i++) {
            if(find(nums[i]) != find(st[i])) return false;
        }
        return true;
    }
    private int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            p[px] = py;
        }
    }
}