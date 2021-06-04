class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1];
        while(l < r) {
            int mid = l + r >> 1;
            if(Check(position, m, mid)) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l - 1;
    }
    private boolean Check(int[] position, int m, int min) {
        int lastValue = position[0];
        int index = 1;
        int ballsLeft = m - 1;
        while(index < position.length && ballsLeft > 0) {
            if(position[index] - lastValue >= min) {
                lastValue = position[index];
                ballsLeft--;
            }
            index++;
        }
        return ballsLeft == 0;
    }
}