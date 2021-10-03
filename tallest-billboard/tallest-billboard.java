class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for(int r : rods) {
            Map<Integer, Integer> clone = new HashMap<>(dp);
            for(int dif : dp.keySet()) {
                clone.put(dif + r, Math.max(clone.getOrDefault(dif + r, 0), dp.get(dif) + r));
                clone.put(dif - r, Math.max(clone.getOrDefault(dif - r, 0), dp.get(dif)));
            }
            dp = clone;
        }
        return dp.get(0);
    }
}