class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digit = new ArrayList<String>();
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        for(String log : logs) {
            int idx = log.indexOf(' ');
            if(Character.isDigit(log.charAt(idx + 1))) {
                digit.add(log);
            }
            else {
                map.putIfAbsent(log.substring(idx + 1), new TreeSet<>());
                map.get(log.substring(idx + 1)).add(log.substring(0, idx));
            }
        }
        int idx = 0;
        String[] res = new String[logs.length];
        for(Map.Entry<String, TreeSet<String>> entry : map.entrySet()) {
            for(String str : entry.getValue()) {
                res[idx++] = str + " " + entry.getKey();
            }
        }
        for(String str : digit) {
            res[idx++] = str;
        }
        return res;
    }
}