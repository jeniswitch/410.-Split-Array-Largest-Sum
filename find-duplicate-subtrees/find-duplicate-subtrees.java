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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, res, new HashMap<String, Integer>());
        return res;
    }
    private String helper(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
        if(node == null) return "N";
        String str = node.val + ","+ helper(node.left, res, map) + "," + helper(node.right, res, map);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if(map.get(str) == 2) res.add(node);
        return str;
    }
}