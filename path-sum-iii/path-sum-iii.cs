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
    private Dictionary<int, int> dic;
    private int targetSum;
    private int count;
    public int PathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dic = new Dictionary<int, int>();
        count = 0;
        Helper(root, 0);
        return count;
    }
    private void Helper(TreeNode node, int crrSum) {
        if(node == null) {
            return;
        }
        crrSum += node.val;
        if(crrSum == targetSum) {
            count++;
        }
        if(dic.ContainsKey(crrSum - targetSum)) {
            count += dic[crrSum - targetSum];
        }
        if(dic.ContainsKey(crrSum)) {
            dic[crrSum]++;
        }
        else {
            dic.Add(crrSum, 1);
        }
        Helper(node.left, crrSum);
        Helper(node.right, crrSum);
        dic[crrSum]--;
    }
}