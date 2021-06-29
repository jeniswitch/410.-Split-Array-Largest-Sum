class MyHashSet {
    private Bucket[] bucket;
    private final int N = 769;
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = new Bucket[N];
        for(int i = 0; i < N; i++) {
            bucket[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        bucket[key % N].add(key);
    }
    
    public void remove(int key) {
        bucket[key % N].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucket[key % N].contains(key);
    }
    public class Bucket {
        private LinkedList<Integer> lst;
        public Bucket () {
            lst = new LinkedList<Integer>();
        }
        public boolean contains(Integer key) {
            return lst.indexOf(key) > -1;
        }
        public void add(Integer key) {
            if(!contains(key)) {
                lst.addFirst(key);
            }
        }
        public void remove(Integer key) {
            lst.remove(key);
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
