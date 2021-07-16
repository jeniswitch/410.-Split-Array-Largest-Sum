class Solution {
    public class Trie {
        public Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    private Trie root;
    public int findMaximumXOR(int[] nums) {
        root = new Trie();
        for(int num : nums) {
            insert(num);
        }
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, query(num));
        }
        return max;
    }
    private void insert(int num) {
        Trie node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if(node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
        }
    }
    private int query(int num) {
        Trie node = root;
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if(node.children[bit ^ 1] != null) {
                res += 1 << i;
                node = node.children[bit ^ 1];
            }
            else {
                node = node.children[bit];
            }
        }
        return res;
    }
}