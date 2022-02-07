class Solution {
    private int[] p, s;
    public int[] groupStrings(String[] words) {
        int l = words.length;
        int[] mask = new int[l];
        p = new int[l];
        s = new int[l];
        Map<Integer, Integer> map = new HashMap<>();
        //initialize Union Find arrays, mask for each word
        for(int i = 0; i < l; i++) {
            p[i] = i;
            s[i] = 1;
            String word = words[i];
            int x = 0;
            for(int j = 0; j < word.length(); j++) {
                x = x | (1 << (word.charAt(j) - 'a'));
            }
            map.put(x, i);
            mask[i] = x;
        }
        for(int i = 0; i < l; i++) {
            int x = mask[i];
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                x = x & (~(1 << (c - 'a')));//remove c
                if(map.containsKey(x)) {
                    union(i, map.get(x));
                }
                //replace with 'a' to 'z'
                for(char ca = 'a'; ca <= 'z'; ca++) {
                    int digit = (x >> (ca - 'a')) & 1;
                    if(digit == 1) continue;
                    x = x | (1 << (ca - 'a'));
                    if(map.containsKey(x)) {
                        union(i, map.get(x));
                    }
                    x = x & (~(1 << (ca - 'a'))); //reset ca
                }
                x = x | (1 << (c - 'a'));//add ca back
            }
        }

        //sumarrize group
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < l; i++) {
            int pi = parent(i);
            set.add(pi);
            max = Math.max(max, s[pi]);
        }
        return new int[]{set.size(), max};
    }
    private int parent(int i) {
        if(p[i] != i) {
            p[i] = parent(p[i]);
        }
        return p[i];
    }
    private void union(int i, int j) {
        int pi = parent(i);
        int pj = parent(j);
        if(pi != pj) {
            p[pi] = pj;
            s[pj] += s[pi];
        }
    }
}