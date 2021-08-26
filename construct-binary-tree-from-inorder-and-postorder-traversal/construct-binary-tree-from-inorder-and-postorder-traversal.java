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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = inorder.length - 1;
        return helper(inorder, postorder, map, 0, n, 0, n);
    }
    private TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int iStart, int iEnd, int pStart, int pEnd) {
        if(iStart > iEnd) {
            return null;
        }
        if(iStart == iEnd) {
            return new TreeNode(inorder[iStart]);
        }
        int idx = map.get(postorder[pEnd]);
        TreeNode parrent = new TreeNode(postorder[pEnd]);
        int leftLen = idx - iStart;
        int rightLen = iEnd - idx;
        parrent.left = leftLen == 0 ? null : helper(inorder, postorder, map, iStart, idx - 1, pStart, pEnd - rightLen - 1);
        parrent.right = rightLen == 0 ? null : helper(inorder, postorder, map, idx + 1, iEnd, pEnd - rightLen, pEnd - 1);
        return parrent;
     }
}