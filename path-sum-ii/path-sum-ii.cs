/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private IList<IList<int>> res;
    private int count;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        res = new List<IList<int>>();
        count = 0;
        Helper(root, targetSum, new List<int>());
        return res;
    }
    private void Helper(TreeNode node, int targetSum, IList<int> temp) {
        if(node == null) {
            return;
        }
        temp.Add(node.val);
        count += node.val;
        if(node.left == null && node.right == null) {
            if(count == targetSum) {
                res.Add(new List<int>(temp));
            }
            count -= node.val;
            temp.RemoveAt(temp.Count - 1);
            return;
            
        }
        Helper(node.left, targetSum, temp);
        Helper(node.right, targetSum, temp);
        count -= node.val;
        temp.RemoveAt(temp.Count - 1);
    }
}