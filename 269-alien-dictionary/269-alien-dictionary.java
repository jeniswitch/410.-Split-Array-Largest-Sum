class Solution {
    public String alienOrder(String[] words) {
        int N = 26;
        Map<Character, List<Character>> map = new HashMap<>();
        int[] d = new int[N];
        int count = 0;
        for(String w : words) {
            for(char c : w.toCharArray()) {
                if(d[c - 'a'] == 0) {
                    d[c - 'a'] = 1;
                    count++;
                }
            }
        }
        for(int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            boolean same = true;
            while(j < len) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2) {
                    same = false;
                    List<Character> lst = map.getOrDefault(c1, new ArrayList<>());
                    lst.add(c2);
                    map.put(c1, lst);
                    d[c2 - 'a']++;
                    break;
                }
                j++;
            }
            if(same && w1.length() > w2.length()) {
                return "";
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(d[i] == 1){
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int crr = q.poll();
                char c = (char)(crr + 'a');
                sb.append(c);
                for(Character i : map.getOrDefault(c, new ArrayList<>())) {
                    d[i - 'a']--;
                    if(d[i - 'a'] == 1) {
                        q.offer(i - 'a');
                    } 
                }
            }
        }
        if(sb.length() != count) return "";
        return sb.toString();
    }
}