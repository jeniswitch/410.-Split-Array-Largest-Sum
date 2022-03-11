class Solution {
    private HashMap<String, List<String>> map;
    private HashSet<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        visited = new HashSet<>();
        map = new HashMap<>();
        int l = beginWord.length();
        for(String word : wordList) {
            for(int i = 0; i < l; i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1);
                if(!map.containsKey(w)) {
                    map.put(w, new ArrayList<>());
                }
                map.get(w).add(word);
            }
        }
        //if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            while(size-- > 0) {
                String crr = q.poll();
                //visited.add(crr);
                for(int j = 0; j < l; j++) {
                    String next = crr.substring(0, j) + "*" + crr.substring(j + 1);
                    for(String w : map.getOrDefault(next, new ArrayList<>())) {
                        if(w.equals(endWord)) return count + 1;
                        if(visited.contains(w)) continue;
                        visited.add(w);
                        q.offer(w);
                    }
                }
            }
        }
        return 0;
    }
    
}