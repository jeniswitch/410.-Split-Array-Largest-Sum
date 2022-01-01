class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        int len = words.size();
        String[] res = new String[len];
        int[] prefix = new int[len];
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            prefix[i] = 1;
            res[i] = abr(words.get(i), 1);
            map.putIfAbsent(res[i], new ArrayList<>());
            map.get(res[i]).add(i);
        }
        for(int i = 0; i < len; i++) {
            if(map.get(res[i]).size() > 1) {
                List<Integer> indexes = map.get(res[i]);
                map.remove(res[i]);
                for(int k : indexes) {
                    res[k] = abr(words.get(k), ++prefix[k]);
                    map.putIfAbsent(res[k], new ArrayList<>());
                    map.get(res[k]).add(k);
                }
                i--;
            }
        }
        return Arrays.asList(res);
    }
    private String abr(String str, int k) {
        if(k >= str.length() - 2) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, k));
        sb.append(str.length() - 1 - k);
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}