class DetectSquares {
    private int[][] p;
    private List<int[]> points;
    private final int N = 1001;
    public DetectSquares() {
        p = new int[N][N];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        p[point[0]][point[1]]++;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        for(int[] po : points) {
            if(Math.abs(po[0] - x)> 0 && Math.abs(po[0] - x) == Math.abs(po[1] - y)) {
                res += p[x][po[1]] * p[po[0]][y];
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */