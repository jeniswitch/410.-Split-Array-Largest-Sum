class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] d = new int[numCourses];
        for(int[] pr : prerequisites) {
            if(!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
            d[pr[0]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(d[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        if(q.isEmpty()) {
            return new int[0];
        }
        int idx = 0;
        while(!q.isEmpty()) {
            int crr = q.poll();
            res[idx++] = crr;
            if(map.containsKey(crr)) {
               for(int i : map.get(crr)) {
                    d[i]--;
                    if(d[i] == 0) {
                        q.offer(i);
                    }
                } 
            }
            
        }
        if(idx != numCourses) {
            return new int[0]; 
        }
        return res;
    }
}