public class Solution {
    public int MinSpeedOnTime(int[] dist, double hour) {
        int start = 0, end = 10000000;
        int res = -1;
        while(start <= end) {
            int speed = start + (end - start) / 2;
            double temphour = 0;
            for(int i = 0; i < dist.Length - 1; i++) {
                temphour += Math.Ceiling(((double)dist[i]) / speed);
            }
            temphour += ((double)dist[dist.Length - 1]) / speed;
            if(temphour <= hour) {
                res = speed;
                end = speed - 1;
            }
            else {
                start = speed + 1;
            }
        }
        return res;
    }
}