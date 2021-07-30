class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[profits.length][2];
        for(int i = 0; i < profits.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int i = 0;
        while(k > 0) {
            while(i < profits.length && arr[i][1] <= w) {
                pq.offer(arr[i++]);
            }
            if(pq.isEmpty()) {
                return w;
            }
            int[] picked = pq.poll();
            w += picked[0];
            k--;
        }
        return w;
    }
}