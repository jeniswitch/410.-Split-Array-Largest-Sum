class Solution {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        if(i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != color) {
            return;
        }
        image[i][j] = newColor;
        for(int[] d : dir) {
            dfs(image, i + d[0], j + d[1], color, newColor);
        }
    }   
}