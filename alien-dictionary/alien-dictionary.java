class Solution {
    public String alienOrder(String[] words) {
        int[] d = new int[26];
        Arrays.fill(d, -1);
        for(String w : words) {
            for(char c : w.toCharArray()) {
                if(d[c - 'a'] == -1) {
                    d[c - 'a']++;
                }
            }
        }
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < words.length - 1; i++) {
            String crr = words[i];
            String next = words[i + 1];
            int len = Math.min(crr.length(), next.length());
            boolean same = true;
            for(int j = 0; j < len; j++) {
                char c1 = crr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2) {
                    same = false;
                    map.putIfAbsent(c1, new HashSet<>());
                    if(!map.get(c1).contains(c2)) {
                        d[c2 - 'a']++;
                        map.get(c1).add(c2);
                    }
                    break;
                }
            }
            if(same && crr.length() > next.length()) {
                return "";
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < d.length; i++) {
            if(d[i] == 0) {
                q.offer(i);
            }
        }
        String res = "";
        while(!q.isEmpty()) {
            int c = q.poll();
            char cChar = (char)(c + 'a');
            res += cChar;
            if(map.containsKey(cChar)) {
                Iterator it = map.get(cChar).iterator();
                while(it.hasNext()) {
                    char next = (char)it.next();
                    int idx = next - 'a';
                    d[idx]--;
                    if(d[idx] == 0) {
                        q.offer(idx);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < d.length; i++) {
            if(d[i] >= 0) {
                count++;
            }
        }
        return count == res.length() ? res : "";
    }
}