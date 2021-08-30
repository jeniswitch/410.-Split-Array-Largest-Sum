class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] p = new int[n];
        Arrays.fill(p, Integer.MAX_VALUE);
        p[src] = 0;
        while(k >= 0) {
            int[] temp = Arrays.copyOf(p, n);
            for(int[] flight : flights) {
                int a = flight[0];
                int b = flight[1];
                int c = flight[2];
                if(p[a] == Integer.MAX_VALUE) continue;
                temp[b] = Math.min(temp[b], p[a] + c);
            }
            p = temp;
            k--;
        }
        return p[dst] == Integer.MAX_VALUE ? -1 : p[dst];
    }
}