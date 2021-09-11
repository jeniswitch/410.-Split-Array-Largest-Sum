class Solution {
    private int[] p, size;
    private int max;
    public int largestComponentSize(int[] nums) {
        p = new int[nums.length];
        size = new int[nums.length];
        max = 1;
        for(int i = 0; i < nums.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for(int j = 2; j * j <= a; j++) {
                if(a % j == 0) {
                    if(!map.containsKey(j)) {
                        map.put(j, i);
                    }
                    else {
                        union(i, map.get(j));
                    }
                    if(!map.containsKey(a / j)) {
                        map.put(a / j, i);
                    }
                    else {
                        union(i, map.get(a / j));
                    }
                }
            }
            if(!map.containsKey(a)) {
                map.put(a, i);
            }
            else {
                union(i, map.get(a));
            }
        }
        return max;
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
            size[py] += size[px];
            max = Math.max(max, size[py]);
        }
    }
}