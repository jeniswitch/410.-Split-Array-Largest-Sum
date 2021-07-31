class Solution {
    private static final long MOD = (long)(1e9 + 7);
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[speed.length][2];
        for(int i = 0; i < speed.length; i++) {
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, res = 0;
        for(int[] a : arr) {
            sum += a[1];
            pq.offer(a[1]);
            if(pq.size() > k) {
                sum -= pq.poll();
            }
            res = Math.max(res, sum * a[0]);
        }
        return (int) (res % MOD);
    }
}
