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
class Solution {
    private List<List<String>> res;
    private int rows, cols;
    public List<List<String>> printTree(TreeNode root) {
        res = new ArrayList<>();
        rows = root == null ? 1 : getHeight(root);
        cols = (int)Math.pow(2, rows) - 1;
        List<String> lst = new ArrayList<>();
        for(int i = 0; i < cols; i++) {
            lst.add("");
        }
        for(int i = 0; i < rows; i++) {
            res.add(new ArrayList<>(lst));
        }
        helper(root, 0, 0, cols - 1);
        return res;
    }
    private int getHeight(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    private void helper(TreeNode node, int row, int i, int j) {
        if(node == null || row == rows) return;
        res.get(row).set((i + j) / 2, Integer.toString(node.val));
        helper(node.left, row + 1, i, (i + j) / 2 - 1);
        helper(node.right, row + 1, (i + j) / 2 + 1, j);
    }
}