class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length == 1) return 0;
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            }
            else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        /*for(HashMap.Entry<Integer, Integer> entry : odd.entrySet()) {
            int key = entry.getKey();
            if(even.getOrDefault(key, 0) > 0) {
                if(even.get(key) < entry.getValue()) {
                    even.put(key, 0);
                }
                else {
                    odd.put(key, 0);
                }
            }
        }*/
        for(HashMap.Entry<Integer, Integer> entry : even.entrySet()) {
            int key = entry.getKey();
            if(odd.getOrDefault(key, 0) > 0) {
                if(odd.get(key) < entry.getValue()) {
                    odd.put(key, 0);
                }
                else {
                    even.put(key, 0);
                }
            }
        }
        int o = 0, e = 0;
        for(int v : odd.keySet()) o = Math.max(o, odd.get(v));
        for(int v : even.keySet()) e = Math.max(e, even.get(v));
        return nums.length - o - e;
    }
}