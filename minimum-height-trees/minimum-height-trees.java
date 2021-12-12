class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> lst = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        if(n == 1) {
            leaves.add(0);
            return leaves;
        }
        for(int i = 0; i < n; i++) {
            lst.add(new HashSet<Integer>());
        }
        for(int[] edge : edges) {
            lst.get(edge[0]).add(edge[1]);
            lst.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if(lst.get(i).size() == 1) leaves.add(i);
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> tempLeaves = new ArrayList<>();
            for(int l : leaves) {
                int next = lst.get(l).iterator().next();
                lst.get(next).remove(l);
                if(lst.get(next).size() == 1) tempLeaves.add(next);
            }
            leaves = tempLeaves;
        }
        return leaves;
    }
}