class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int[] d = new int[numCourses];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites) {
            map.putIfAbsent(p[1], new HashSet<Integer>());
            map.get(p[1]).add(p[0]);
            d[p[0]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(d[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int c = q.poll();
            count++;
            if(map.containsKey(c)) {
                Iterator<Integer> it = map.get(c).iterator();
                while(it.hasNext()) {
                    int a = it.next();
                    d[a]--;
                    if(d[a] == 0) {
                        q.offer(a);
                    }
                }
            }           
        }
        return count == numCourses;
    }
}