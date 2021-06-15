/*
//[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]
1   0, 1                1   0
2   2,3,4               
3   5                   
                        4   1,5,3
                        5   2,4
count(7): use TreeMap<Integer, TreeSet<Integer>>, 7 - nums1[i] in nums2[2]?

*/
class FindSumPairs {
    private TreeMap<Integer, TreeSet<Integer>> tm1;
    private TreeMap<Integer, TreeSet<Integer>> tm2;
    private int[] nums1;
    private int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        tm1 = new TreeMap<Integer, TreeSet<Integer>>();
        tm2 = new TreeMap<Integer, TreeSet<Integer>>();
        this.nums1 = nums1.clone();
        this.nums2 = nums2.clone();
        for(int i = 0; i < nums1.length; i++) {
            addKeyValue(tm1, nums1[i], i);
        }
        for(int i = 0; i < nums2.length; i++) {
            addKeyValue(tm2, nums2[i], i);
        }
    }
    
    public void add(int index, int val) {
        int oldNum = nums2[index];
        nums2[index] += val;
        addKeyValue(tm2, nums2[index], index);
        tm2.get(oldNum).remove(index);
        //System.out.println(tm2);
        //System.out.println(oldNum + " " + nums2[index] + " " + tm2.get(oldNum).size());
        if(tm2.get(oldNum).size() == 0) {
            tm2.remove(oldNum);
        }
        //System.out.println(tm2);
    }
    
    public int count(int tot) {
        Iterator<Integer> iterator = tm1.keySet().iterator();
        int res = 0;
        while(iterator.hasNext()) {
            int num1 = iterator.next();
            int target = tot - num1;
            if(tm2.containsKey(target)) {
                res += tm1.get(num1).size() * tm2.get(target).size();
            }
        }
        return res;
    }
    
    private void addKeyValue(TreeMap<Integer, TreeSet<Integer>> tm, int key, int val) {
        if(tm.containsKey(key)) {
            tm.get(key).add(val);
        }
        else {
            var ts = new TreeSet<Integer>();
            ts.add(val);
            tm.put(key, ts);
        }
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */