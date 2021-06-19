class Solution {
    public int longestWPI(int[] hours) {
        var hp = new HashMap<Integer, Integer>();
        int score = 0, res = 0;
        for(int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if(score > 0) {
                res = i + 1;
            }
            else {
                hp.putIfAbsent(score, i);
                if(hp.containsKey(score - 1)) {
                    res = Math.max(res, i - hp.get(score - 1));
                }
            }
        }
        return res;
    }
}