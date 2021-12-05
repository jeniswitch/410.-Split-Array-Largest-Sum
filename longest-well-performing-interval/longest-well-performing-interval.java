class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int score = 0;
        for(int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if(score > 0) {
                res = i + 1;
            }
            else {
                map.putIfAbsent(score, i);
                if(map.containsKey(score - 1)) {
                    res = Math.max(res, i - map.get(score - 1));
                }
            }
        }
        return res;
    }
}