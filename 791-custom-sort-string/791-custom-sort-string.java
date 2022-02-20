class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                add(map.get(c), c, sb);
                map.remove(c);
            }
        }
        for(char k : map.keySet()) {
            add(map.get(k), k, sb);
        }
        return sb.toString();
    }
    private void add(int count, char c, StringBuilder sb) {
        for(int j = 0; j < count; j++) {
            sb.append(c);
        }
    }
}