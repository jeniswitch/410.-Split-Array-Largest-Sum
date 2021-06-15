class FindSumPairs {
    private HashMap<Integer, Integer> hp;
    private int[] nums1;
    private int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        hp = new HashMap<Integer, Integer>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i = 0; i < nums2.length; i++) {
            increaseFreq(nums2[i], 1);
        }
    }
    
    public void add(int index, int val) {
        increaseFreq(nums2[index], -1);
        nums2[index] += val;
        increaseFreq(nums2[index], 1);
    }
    
    public int count(int tot) {
        int res = 0;
        for(int i = 0; i < nums1.length; i++) {
            res += hp.getOrDefault(tot - nums1[i], 0);
        }
        return res;
    }
    
    public void increaseFreq(int key, int freq) {
        hp.put(key, hp.getOrDefault(key, 0) + freq);
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
