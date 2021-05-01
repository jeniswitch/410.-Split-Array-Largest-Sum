/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Dictionary<TreeNode, List<TreeNode>> dic;
    public IList<int> DistanceK(TreeNode root, TreeNode target, int K) {
        dic = new Dictionary<TreeNode, List<TreeNode>>();
        IList<int> res = new List<int>();
        BuildGraph(root, null);
        var q = new Queue<TreeNode>();
        var visited = new HashSet<TreeNode>();
        q.Enqueue(target);
        visited.Add(target);
        int count = 0;
        while(q.Count > 0) {
            int size = q.Count;
            if(count == K) {
                for(int i = 0; i < size; i++) {
                    res.Add(q.Dequeue().val);
                }
                return res;
            }
            for(int i = 0; i < size; i++) {
                TreeNode node = q.Dequeue();
                foreach(TreeNode n in dic[node]) {
                    if(visited.Contains(n)) {
                        continue;
                    }
                    q.Enqueue(n);
                    visited.Add(n);
                }
            }
            count++;
        }
        return res;
    }
    private void BuildGraph(TreeNode node, TreeNode parent) {
        if(node == null) {
            return;
        }
        if(!dic.ContainsKey(node)) {
            dic.Add(node, new List<TreeNode>());
        }
        if(parent != null) {
            dic[node].Add(parent);
            dic[parent].Add(node);
        }
        BuildGraph(node.left, node);
        BuildGraph(node.right, node);
    }
}