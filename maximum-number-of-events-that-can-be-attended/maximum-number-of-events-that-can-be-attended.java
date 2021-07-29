class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, i = 0;
        for(int d = 1; d <= 100000; d++) {
            //remove event ended before today
            while(!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            //add all the events start at today
            while(i < n && events[i][0] == d) {
                pq.offer(events[i++][1]);
            }
            //attend the event that ends early
            if(!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            if(i == n && pq.isEmpty()) {
                break;
            }
        }
        return res;
    }
}