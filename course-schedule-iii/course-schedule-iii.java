class Solution {
    public int scheduleCourse(int[][] courses) {
        int t = 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int[] c : courses) {
           t += c[0];
           pq.offer(c[0]);
           if(t > c[1]) {
               t -= pq.poll();
           }
        }
        return pq.size();
    }
}