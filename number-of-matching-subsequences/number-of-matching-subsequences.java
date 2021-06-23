class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer[]>[] waiting = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            waiting[i] = new ArrayList<Integer[]>();
        }
        for(int i = 0; i < words.length; i++) {
            waiting[words[i].charAt(0) - 'a'].add(new Integer[]{i, 1});
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            List<Integer[]> advanced = new ArrayList(waiting[s.charAt(i) - 'a']);
            waiting[s.charAt(i) - 'a'].clear();
            for(Integer[] item : advanced) {
                if(item[1] < words[item[0]].length()) {
                    waiting[words[item[0]].charAt(item[1]++) - 'a'].add(item);
                }
                else {
                    res++;
                }
            }
            
        }
        return res;
    }
}