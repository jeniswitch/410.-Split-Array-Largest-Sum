class MyHashMap {
    private ListNode[] lst;
    private final int N = 1000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        lst = new ListNode[N];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = findIdx(key);
        if(lst[idx] == null) {
            lst[idx] = new ListNode(0, 0);
        }
        if(lst[idx].next == null) {
            lst[idx].next = new ListNode(key, value);
        }
        else {
            ListNode node = findNode(lst[idx], key);
            if(node.next == null) {
                node.next = new ListNode(key, value);
            }
            else {
                node.next.val = value;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = findIdx(key);
        if(lst[idx] == null || lst[idx].next == null) {
            return -1;
        }
        ListNode node = findNode(lst[idx], key);
        if(node.next == null) {
            return -1;
        }
        else {
            return node.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = findIdx(key);
        if(lst[idx] == null || lst[idx].next == null) {
            return;
        }
        ListNode pre = findNode(lst[idx], key);
        if(pre.next != null) {
            pre.next = pre.next.next;
        }
    }
    private int findIdx(Integer key) {
        return key.hashCode() % N;
    }
    private ListNode findNode(ListNode head, int key) {
        ListNode pre = head;
        ListNode crr = head.next;
        while(crr != null && crr.key != key) {
            pre = crr;
            crr = crr.next;
        }
        return pre;
    }
    public class ListNode {
        public ListNode next;
        public int key;
        public int val;
        public ListNode(int k, int v) {
            key = k;
            val = v;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */