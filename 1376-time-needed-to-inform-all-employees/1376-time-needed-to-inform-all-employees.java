class Solution {
    private int max;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //HashMap<Integer, Integer> max = new HashMap<>();
        for(int i = 0; i < manager.length; i++) {
            if(manager[i] != -1) {
                map.putIfAbsent(manager[i], new ArrayList<>());
                map.get(manager[i]).add(i);
                //map.put(manager[i], Math.max(max.getOrDefault(manager[i], 0), informTime(i)));
            }
        }
        return dfs(map, headID, informTime);
    }
    private int dfs(HashMap<Integer, List<Integer>> map, int key, int[] informTime) {
        if(!map.containsKey(key)) return 0;
        List<Integer> lst = map.get(key);
        int localMax = 0;
        for(int id : lst) {
            localMax = Math.max(localMax, dfs(map, id, informTime));
        }
        return localMax + informTime[key];
    }
}