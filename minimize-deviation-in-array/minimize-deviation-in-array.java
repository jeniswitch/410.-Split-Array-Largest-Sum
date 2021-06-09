/*
find res = max - min
we want min(res). we can hold min, decrease max or holod max and increase min.
here, we decrease max to find min(res).
1. odd -> odd * 2(becomes even) (-> even/2 will lead to infinit loop), so we multiply odd by 2 once.
    3*2=6 (6/2=3)
2. after step 1, we have the true max, now we can start decresing it.
3. now it is all even. get the max, and divide it by 2, stop when it becomes odd.
    20/2=10 10/2=5 (5*2=10)
4. keep tracking min and min(res);
use prioirty queue
*/
class Solution {
    public int minimumDeviation(int[] nums) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int num : nums) {
            int x = num % 2 == 1 ? num * 2 : num;
            pq.offer(x);
            min = Math.min(min, x);
        }
        while(!pq.isEmpty()) {
            int x = pq.poll();
            res = Math.min(res, x - min);
            if(x % 2 == 1) {
                return res;
            }
            pq.offer(x / 2);
            min = Math.min(min, x / 2);
        }
        return res;
    }
}