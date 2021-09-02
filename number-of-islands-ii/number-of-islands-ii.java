class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        int count = 0;
        int[] parrent = new int[m * n];
        Arrays.fill(parrent, -1);
        final int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] p : positions) {
            int idx = n * p[0] + p[1];
            if(parrent[idx] != -1) {
                res.add(count);
                continue;
            }
            parrent[idx] = idx;
            count++;
            
            for(int[] dir : d) {
                int npx = p[0] + dir[0];
                int npy = p[1] + dir[1];
                int nidx = npx * n + npy;
                if(npx < 0 || npy < 0 || npx == m || npy == n || parrent[nidx] == -1) continue;
                
                int newParrent = find(parrent, nidx);
                if(idx != newParrent) {
                    parrent[idx] = newParrent;
                    idx = newParrent;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int find(int[] p, int i) {
        if(p[i] != i) p[i] = find(p, p[i]);
        return p[i];
    }
}