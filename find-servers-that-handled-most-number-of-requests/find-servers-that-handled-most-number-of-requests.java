class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        var available = new TreeSet<Integer>();
        for(int i = 0; i < k; i++) {
            available.add(i);
        }
        int[] count = new int[k];
        int maxCount = 0;
        var pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]); //min heap <endTime, index>
        for(int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int endTime = startTime + load[i];
            while(!pq.isEmpty() && pq.peek()[0] <= startTime) {
                available.add(pq.poll()[1]);
            }
            if(available.size() == 0) {
                continue;
            }
            Integer server = available.ceiling(i % k);
            if(server == null) {
                server = available.first();
            }
            pq.offer(new int[]{endTime, server});
            available.remove(server);
            maxCount = Math.max(maxCount, ++count[server]);
        }
        var res = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            if(count[i] == maxCount) {
                res.add(i);
            }
        }
        return res;
    }
}