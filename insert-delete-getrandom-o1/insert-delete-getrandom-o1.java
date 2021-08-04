class RandomizedSet {
    private ArrayList<Integer> num;
    private HashMap<Integer, Integer> map;//val, index
    private Random rdm;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        num = new ArrayList<>();
        map = new HashMap<>();
        rdm = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        num.add(val);
        map.put(val, num.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        if(idx != num.size() - 1) {
            int lastVal = num.get(num.size() - 1);
            num.set(idx, lastVal);
            map.put(lastVal, idx);
        }

        map.remove(val);
        num.remove(num.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return num.get(rdm.nextInt(num.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */