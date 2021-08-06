class Solution {
    private TreeMap<Integer, Integer> map;//area, index of recs
    private Random rand;
    private int sum;
    private int[][] rects;
    public Solution(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        rand = new Random();
        sum = 0;
        for(int i = 0; i < rects.length; i++) {
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(sum, i);
        }
    }
    
    public int[] pick() {
        int key = map.ceilingKey(rand.nextInt(sum) + 1);
        int[] rec = rects[map.get(key)];
        int left = rec[0], right = rec[2], top = rec[3], bot = rec[1];
        int x = left + rand.nextInt(right - left + 1);
        int y = bot + rand.nextInt(top - bot + 1);
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */