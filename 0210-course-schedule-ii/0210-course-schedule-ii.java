class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int[] c : prerequisites) {
            inDegree[c[0]]++;
            List<Integer> arr = map.getOrDefault(c[1], new ArrayList<>());
            arr.add(c[0]);
            map.put(c[1], arr);
        }
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        if(q.size() == 0) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
                res[idx++] = course;
                List<Integer> nbs = map.getOrDefault(course, new ArrayList<>());
                for(Integer nb : nbs) {
                    inDegree[nb]--;
                    if(inDegree[nb] == 0) {
                        q.offer(nb);
                    }
                }
        }
        if(idx != numCourses) {
            return new int[0];
        }
        return res;
    }
}