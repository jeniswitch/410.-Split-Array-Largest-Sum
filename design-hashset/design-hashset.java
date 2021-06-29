class MyHashSet {
    private boolean[] arr;
    private final int N = (int)1e6 + 1;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[N];
    }
    
    public void add(int key) {
        if(!contains(key)) {
            arr[key] = true;
        }
    }
    
    public void remove(int key) {
        if(contains(key)) {
            arr[key] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */