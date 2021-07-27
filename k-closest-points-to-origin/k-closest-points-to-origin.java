class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (x, y) -> x[0] * x[0] + x[1] * x[1] - (y[0] * y[0] + y[1] * y[1]));
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }
}