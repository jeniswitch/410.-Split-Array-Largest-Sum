class RandomizedCollection {
    private ArrayList<Integer> lst;
    private HashMap<Integer, LinkedHashSet<Integer>> map;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if(!contains) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(lst.size());
        lst.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        if(index != lst.size() - 1) {
            lst.set(index, lst.get(lst.size() - 1));
            map.get(val).remove(index);
            map.get(lst.get(index)).add(index);
        }
        map.get(lst.get(index)).remove(lst.size() - 1);
        lst.remove(lst.size() - 1);
        if(map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */