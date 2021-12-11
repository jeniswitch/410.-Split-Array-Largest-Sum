/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private List<Integer> lst;
    private int idx;
    public BSTIterator(TreeNode root) {
        lst = new ArrayList<>();
        idx = 0;
        helper(root);
    }
    
    public int next() {
        return lst.get(idx++);
    }
    
    public boolean hasNext() {
        return idx < lst.size();
    }
    private void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        helper(node.left);
        lst.add(node.val);
        helper(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */