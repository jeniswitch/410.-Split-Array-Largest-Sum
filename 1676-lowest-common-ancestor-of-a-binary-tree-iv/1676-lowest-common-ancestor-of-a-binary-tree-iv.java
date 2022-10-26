/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(nodes.length == 0) {
            return null;
        }
        if(nodes.length == 1) {
            return nodes[0];
        }
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node : nodes) {
            set.add(node);
        }
        helper(root, set);
        return lca;
    }
    private int helper(TreeNode root, Set<TreeNode> set) {
        if(root == null) return 0;
        int count = 0;
        if(set.contains(root)) count++;
        count += helper(root.left, set);
        count += helper(root.right, set);
        if(count == set.size() && lca == null) {
            lca = root;
        }
        return count;
    }
}